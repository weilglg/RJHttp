package com.cn.rx.entity;

import java.io.File;
import java.io.Serializable;

import okhttp3.MediaType;

public class FileEntity<T> implements Serializable {
    private T data;
    private String fileName;
    private long fileSize;
    private MediaType mediaType;

    public FileEntity(T data, String fileName, MediaType mediaType) {
        this.data = data;
        this.fileName = fileName;
        this.mediaType = mediaType;
        if (data instanceof File) {
            this.fileSize = ((File) data).length();
        } else if (data instanceof byte[]) {
            this.fileSize = ((byte[]) data).length;
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public long getFileSize() {
        return fileSize;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }
}
