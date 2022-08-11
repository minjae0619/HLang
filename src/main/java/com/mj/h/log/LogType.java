package com.mj.h.log;

public enum LogType {
    WARN("Warning"),
    ERROR("Error"),
    INFO("Info");

    private String message;
    LogType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
