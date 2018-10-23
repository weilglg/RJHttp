package com.cn.rx.request;

import android.text.TextUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cn.rx.util.Util;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

@SuppressWarnings(value = {"unchecked", "deprecation"})
public class HttpBodyRequest<R extends BaseRequest> extends BaseRequest<R> {
    private RequestBody mRequestBody;
    private String mJsonStr;
    private JSONObject mJsonObj;
    private JSONArray mJsonArr;
    private byte[] mBytes;
    private String mStr;
    private Object mObject;
    private MediaType mMediaType;

    public HttpBodyRequest(String url) {
        super(url);
    }


    public R requestBody(RequestBody requestBody) {
        this.mRequestBody = requestBody;
        return (R) this;
    }

    public R json(String jsonStr) {
        this.mJsonStr = jsonStr;
        return (R) this;
    }

    public R jsonObj(JSONObject obj) {
        this.mJsonObj = obj;
        return (R) this;
    }

    public R jsonArr(JSONArray jsonArray) {
        this.mJsonArr = jsonArray;
        return (R) this;
    }

    public R object(Object obj) {
        this.mObject = obj;
        return (R) this;
    }

    public R bytes(byte[] bytes) {
        this.mBytes = bytes;
        return (R) this;
    }

    public R txt(String txt) {
        this.mStr = txt;
        this.mMediaType = MediaType.parse("text/plain");
        return (R) this;
    }

    public R mediaType(String txt, MediaType mediaType) {
        this.mStr = txt;
        Util.checkNotNull(mediaType, "mediaType==null");
        this.mMediaType = mediaType;
        return (R) this;
    }

    @Override
    protected Observable<ResponseBody> generateRequest() {
        if (mRequestBody != null) {
            return mApiManager.postBody(mUrl, mRequestBody);
        } else if (!TextUtils.isEmpty(mJsonStr)) {
            return mApiManager.potJsonStr(mUrl, Util.createJson(mJsonStr));
        } else if (mJsonObj != null) {
            return mApiManager.postJson(mUrl, mJsonObj);
        } else if (mJsonArr != null) {
            return mApiManager.postJson(mUrl, mJsonArr);
        } else if (!TextUtils.isEmpty(mStr)) {
            RequestBody requestBody = RequestBody.create(mMediaType, mStr);
            return mApiManager.postBody(mUrl, requestBody);
        } else if (mBytes != null) {
            return mApiManager.postBody(mUrl, Util.createBytes(mBytes));
        } else if (mObject != null) {
            return mApiManager.postBody(mUrl, mObject);
        } else if (!mHttpParams.isParamsEmpty() && mHttpParams.isFilesEmpty()) {
            return mApiManager.postMap(mUrl, mHttpParams.getParamMap());
        }  else {
            return mApiManager.post(mUrl);
        }
    }

}
