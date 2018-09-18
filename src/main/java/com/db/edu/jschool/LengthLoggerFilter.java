package com.db.edu.jschool;

public class LengthLoggerFilter implements LoggerFilter {
    private final int maxLength;

    public LengthLoggerFilter(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public boolean filter(String message) {
        return message != null && message.length() > maxLength;
    }
}
