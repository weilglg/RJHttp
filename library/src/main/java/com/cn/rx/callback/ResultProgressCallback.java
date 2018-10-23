package com.cn.rx.callback;

import com.cn.rx.exception.ApiThrowable;

/**
 * 进度回调
 *
 * @author lizhangqu
 * @version V1.0
 * @since 2017-07-12 16:19
 */
public abstract class ResultProgressCallback<T> extends ResultCallback<T> {

    /**
     * 进度发生了改变，如果numBytes，totalBytes，percent，speed都为-1，则表示总大小获取不到
     *
     * @param numBytes   已读/写大小
     * @param totalBytes 总大小
     * @param percent    百分比
     * @param speed      速度 bytes/ms
     */
    public abstract void onUIProgressChanged(Object mTag, long numBytes, long totalBytes, float percent, float speed);

    /**
     * 进度开始
     *
     * @param totalBytes 总大小
     */
    public void onUIProgressStart(Object mTag, long totalBytes) {

    }

    /**
     * 进度结束
     */
    public void onUIProgressFinish(Object mTag) {

    }

    @Override
    public void onStart(Object tag) {

    }

    @Override
    public void onSuccess(Object tag, T t) {

    }

    @Override
    public void onError(Object tag, ApiThrowable e) {

    }
}
