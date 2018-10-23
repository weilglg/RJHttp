package com.cn.rx.subscriber;

import android.content.Context;
import android.text.TextUtils;

import com.cn.rx.callback.DownloadProgressCallBack;
import com.cn.rx.exception.ApiThrowable;
import com.cn.rx.exception.ExceptionFactory;
import com.cn.rx.util.LogUtil;
import com.cn.rx.util.MimeUtils;
import com.cn.rx.util.Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import okhttp3.MediaType;

@SuppressWarnings(value = {"unchecked", "deprecation", "CheckResult"})
public class RxDownloadSubscriber<ResponseBody extends okhttp3.ResponseBody> extends BaseSubscriber<ResponseBody> {

    private WeakReference<Context> contextWeakReference;
    private Object mTag;
    private DownloadProgressCallBack mCallback;
    private String mSavePath;
    private String mSaveName;
    private String mUrl;


    public RxDownloadSubscriber(Object tag, String url, Context mContext, String savePath, String saveName, DownloadProgressCallBack callback) {
        contextWeakReference = new WeakReference<>(mContext);
        this.mSaveName = saveName;
        this.mSavePath = savePath;
        this.mTag = tag;
        this.mCallback = callback;
        this.mUrl = url;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (mCallback != null) {
            mCallback.onStart(mTag);
        }
    }

    @Override
    public void onNext(ResponseBody result) {
        super.onNext(result);
        writeResponseBodyToDisk(result, mTag, mSaveName, mSavePath, mCallback);
    }


    private void writeResponseBodyToDisk(ResponseBody body, final Object mTag, String fileName, String filePath, final DownloadProgressCallBack mCallback) {
        Util.checkNotNull(body, "ResponseBody is null");
        fileName = getFileName(fileName, mUrl, body.contentType());
        LogUtil.i("download", "fileName = " + fileName);
        if (TextUtils.isEmpty(filePath)) {
            filePath = contextWeakReference.get().getExternalFilesDir(null) + File.separator + "Downloads" + File.separator + fileName;
        } else {
            File file = new File(filePath);
            if (!file.exists()) {
                file.mkdirs();
            }
            filePath = filePath + File.separator + fileName;
            filePath = filePath.replaceAll("//", "/");
        }
        LogUtil.i("download", "filePath = " + filePath);
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            File file = new File(filePath);
            if (file.exists()) {
                file.delete();
            }

            long fileSize = body.contentLength();
            long fileSizeDownloaded = 0;
            int updateCount = 0;
            // 定义一次读取的大小
            byte[] fileReader = new byte[1024 * 4];
            inputStream = body.byteStream();
            outputStream = new FileOutputStream(file);
            // 向指定文件写入数据
            while (true) {
                int read = inputStream.read(fileReader);
                if (read == -1) {
                    break;
                }
                outputStream.write(fileReader, 0, read);
                fileSizeDownloaded += read;
                float progress;
                if (fileSize == -1 || fileSize == 0) {
                    progress = 100;
                } else {
                    progress = fileSizeDownloaded * 100 / fileSize;
                }
                if (updateCount == 0 || progress >= updateCount) {
                    updateCount += 1;
                    if (mCallback != null) {
                        final float finaProgress = progress;
                        final long finalFileSize = fileSize;
                        Observable.just(fileSizeDownloaded)
                                .observeOn(AndroidSchedulers.mainThread())
                                .subscribe(new Consumer<Long>() {
                                    @Override
                                    public void accept(Long fileSizeDownloaded) {
                                        mCallback.onProgress(mTag, fileSizeDownloaded, finalFileSize, finaProgress);
                                    }
                                });
                    }
                }
            }
            outputStream.flush();
            if (mCallback != null)
                Observable.just(filePath)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Consumer<String>() {
                            @Override
                            public void accept(String path) {
                                mCallback.onSuccess(mTag, path);

                            }
                        });

        } catch (
                IOException e)

        {
            finalOnError(e);
        } finally

        {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }

                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                finalOnError(e);
            }
        }

    }

    @Override
    public void onError(ApiThrowable throwable) {
        if (mCallback != null) {
            mCallback.onError(mTag, throwable);
        }
    }

    @Override
    public void onComplete() {
        if (mCallback != null) {
            mCallback.onCompleted(mTag);
        }
    }

    private void finalOnError(Exception e) {
        if (mCallback != null)
            Observable.just(e)
                    .observeOn(AndroidSchedulers.mainThread())
                    .map(new Function<Exception, ApiThrowable>() {
                        @Override
                        public ApiThrowable apply(Exception e) {
                            return ExceptionFactory.handleException(e);
                        }
                    }).subscribe(new Consumer<ApiThrowable>() {
                @Override
                public void accept(ApiThrowable apiThrowable) {
                    mCallback.onError(mTag, apiThrowable);
                }
            }, new Consumer<Throwable>() {
                @Override
                public void accept(Throwable throwable) {
                    mCallback.onError(mTag, ExceptionFactory.handleException(throwable));
                }
            });
    }

    private String getFileSuffixByUrl(String url) {
        String fileName = getFileNameByUrl(url);
        // 从路径中获取
        if (fileName != null && !"" .equals(fileName) && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf("."));
        }
        return null;
    }

    private String getFileNameByUrl(String url) {
        String urlReg = "^((ht|f)tps?):\\/\\/([\\w\\-]+(\\.[\\w\\-]+)*\\/)*[\\w\\-]+(\\.[\\w\\-]+)*\\/?(\\?([\\w\\-\\.,@?^=%&:\\/~\\+#]*)+)?";
        Pattern pattern = Pattern.compile(urlReg);
        Matcher matcher = pattern.matcher(url);
        if (matcher.matches()) {
            String nameReg = "([^<>/\\\\\\|:\\'\\'\\*\\?\\&\\=]+)((.(w+)\\?)|(.(\\w+)$))";
            pattern = Pattern.compile(nameReg);
            matcher = pattern.matcher(url);
            if (matcher.find()) {
                return matcher.group();
            }
        }
        return null;
    }

    private String getFileName(String saveName, String url, MediaType mediaType) {
        String fileName = saveName;
        if (TextUtils.isEmpty(fileName)) { // 如果没有配置文件名称，则从Url中解析文件名称
            fileName = getFileNameByUrl(url);
        }
        if (TextUtils.isEmpty(fileName)) { // 如果从Url中没有解析到文件名称，则使用时间戳作为文件名称
            fileName = String.valueOf(System.currentTimeMillis());
        }

        if (!fileName.contains(".")) {
            String fileSuffix = null;
            // 拼接文件名称（名称+后缀）
            if (mediaType != null) {
                // 从Url中获取文件类型
                fileSuffix = getFileSuffixByUrl(url);
                // 从Content-Type中获取文件后缀名
                if (TextUtils.isEmpty(fileSuffix)) {
                    fileSuffix = "." + MimeUtils.guessExtensionFromMimeType(mediaType.toString());
                }
                // 如果前面中都没有，则直接一类型作为后缀名
                if (TextUtils.isEmpty(fileSuffix)) {
                    String subtype = mediaType.subtype();
                    if (!TextUtils.isEmpty(subtype)) {
                        fileSuffix = "." + subtype;
                    }
                }
                //如果前面的都没获取到，则使用默认后缀名
                if (TextUtils.isEmpty(fileSuffix)) {
                    fileSuffix = ".tmpl";
                }
            }
            fileName = fileName + fileSuffix;
        }
        return fileName;
    }

}
