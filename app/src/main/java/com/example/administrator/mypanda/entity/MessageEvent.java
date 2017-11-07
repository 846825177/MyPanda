package com.example.administrator.mypanda.entity;

/**
 * @author 农民伯伯
 * @version 2017/11/6
 */

public class MessageEvent {

    private String message;

    public MessageEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}