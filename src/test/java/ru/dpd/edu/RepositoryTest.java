package ru.dpd.edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.dpd.edu.core.Branch;
import ru.dpd.edu.core.Commit;
import ru.dpd.edu.core.Repository;

class RepositoryTest {
    @Test
    public void test_addBranch() {
        Repository repo = new Repository();
        Branch branch = new Branch("master");
        repo.addBranch(branch);

        Assertions.assertTrue(repo.getBranches().contains(branch));
    }

    @Test
    public void test_addCommit() {
        Branch branch = new Branch("master");
        Commit commit = new Commit("diff", "init", "Витька");
        branch.addCommit(commit);

        Assertions.assertTrue(branch.getCommits().contains(commit));
    }
}