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

    public int getHash() {
        return this.hash;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getDiff() {
        return this.diff;
    }

    public String getMessage() {
        return this.message;
    }

    public LocalDateTime getTime() {
        return this.time;
    }

    @Override
    public String toString() {
        return "Commit [diff=" + this.diff
                + ", message=" + this.message
                + ", author=" + this.author
                + ", time=" + this.time
                + ", hash=" + this.hash
                + "]";
    }
}
