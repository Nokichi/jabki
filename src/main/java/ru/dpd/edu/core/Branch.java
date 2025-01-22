package ru.dpd.edu.core;

import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class Branch {
    private String name;

    private Set<Commit> commits;
    public Branch(String name) {
        this.name = name;
        this.commits = new HashSet<>();
    }

    public void addCommit(Commit commit) {
        this.commits.add(commit);
    }

    public Set<Commit> getCommits() {
        return this.commits;
    }

    public String getName() {
        return this.name;
    }

    public void removeCommit(int hash) {
        for (Commit commit : this.commits) {
            if (commit.getHash() == hash) {
                this.commits.remove(commit);
                return;
            }
        }
        throw new NoSuchElementException("Не найден commit с хэш " + hash + " в ветке " + this.name);
    }

    @Override
    public String toString() {
        return "Branch [name=" + this.name
                + ", commits=" + Arrays.toString(this.commits.toArray())
                + "]";
    }
}
