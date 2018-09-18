package com.db.edu.jschool;

public class Logger {

    private final LoggerFilter filter;
    private final LoggerSaver saver;

    public Logger(LoggerFilter filter, LoggerSaver saver) {
        this.filter = filter;
        this.saver = saver;
    }

    public void log(String message) {
        if (filter.filter(message)) {
            saver.save(message);
        }
    }
}
