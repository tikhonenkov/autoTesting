package com.db.edu.jschool;

public class Logger {

    private final LoggerFilter filter;
    private final LoggerSaver saver;

    public Logger(LoggerFilter filter, LoggerSaver saver) {
        this.filter = filter;
        this.saver = saver;
    }

    public void log(String message) {
        if (message == null) { throw new IllegalArgumentException("Message cannot be null"); }

        if (filter == null) { throw new IllegalStateException("Filter cannot be null"); }
        if (saver == null) { throw new IllegalStateException("Save cannot be null"); }

        if (filter.filter(message)) {
            saver.save(message);
        }
    }
}
