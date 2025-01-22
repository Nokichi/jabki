package ru.dpd.edu.core;

import java.time.LocalDateTime;

public class Commit {
    private String diff;
    private String message;
    private String author;
    private LocalDateTime time;
    private int hash;

    public Commit(String diff, String message, String author) {
        this.diff = diff;
        this.message = message;
        this.author = author;
        this.time = LocalDateTime.now();
        this.hash = (diff + message + author).hashCode();
    }
}
