package com.cn.rx.interceptor;


import com.cn.rx.body.ProgressRequestBody;
import com.cn.rx.callback.ResultProgressCallback;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by admin on 2017/9/5.
 */

public class ProgressRequestInterceptor implements Interceptor {
    private ResultProgressCallback progressListener;
    private Object tag;

    public void setProgressListener(ResultProgressCallback progressListener) {
        this.progressListener = progressListener;
    }

    public void setTag(Object tag) {
        this.tag = tag;
    }

    public ProgressRequestInterceptor(Object tag, ResultProgressCallback progressListener) {
        this.progressListener = progressListener;
        this.tag = tag;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        Request request = original.newBuilder()
                .method(original.method(), new ProgressRequestBody(original.body(), progressListener, tag))
                .build();
        return chain.proceed(request);
    }
}
