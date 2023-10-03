package com.example.spring.studentmanagesystem.handle;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ErrorResponse {
    private int status;
    private String message;
    private Long timestamp;
    private String date;

    public ErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
        this.timestamp = System.currentTimeMillis();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
