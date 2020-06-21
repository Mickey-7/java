package com.example.uploadingfilesspringbootthymeleaf.advice;


public class FileStorageException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private String msg;

    // alt + insert - constructor RuntimeException()
    public FileStorageException(String msg) {
        this.msg = msg;
    }

    // alt + insert - getter
    public String getMsg() {
        return msg;
    }
}

