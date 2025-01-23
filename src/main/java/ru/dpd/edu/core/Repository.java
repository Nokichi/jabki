package ru.dpd.edu.core;

import java.util.Arrays;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;

public class Repository {
    private Set<Branch> branches;

    public Repository() {
        this.branches = new HashSet<>();
    }

    public void addBranch(Branch branch) {
        for (Branch innerBranch : this.branches) {
            if (innerBranch.getName().equals(branch.getName())) {
                throw new IllegalStateException("Ветка " + branch + " уже существует");
            }
        }
        this.branches.add(branch);
    }

    public Set<Branch> getBranches() {
        return this.branches;
    }

    public Commit findCommitByAuthor(String author) {
        for (Branch branch : this.branches) {
            for (Commit commit : branch.getCommits()) {
                if (commit.getAuthor().equals(author)) {
                    return commit;
                }
            }
        }
        throw new NoSuchElementException("В репозитории не найдены коммиты по автору " + author);
    }

    @Override
    public String toString() {
        return "Repository [branches=" + Arrays.toString(this.branches.toArray())
                + "]";
    }
}
