package ru.dpd.edu.core;

import java.util.HashSet;
import java.util.Set;

public class Repository {
    private Set<Branch> branches;

    public Repository() {
        this.branches = new HashSet<>();
    }

    public void addBranch(Branch branch) {
        this.branches.add(branch);
    }

    public Set<Branch> getBranches() {
        return this.branches;
    }
}
