package ru.dpd.edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.dpd.edu.core.Branch;
import ru.dpd.edu.core.Commit;
import ru.dpd.edu.core.Repository;

import java.util.Arrays;

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

    @Test
    public void test_toString() {
        Repository repository = new Repository();
        Branch branch = new Branch("master");
        Commit commit = new Commit("diff", "init", "Pet'ka");
        branch.addCommit(commit);
        repository.addBranch(branch);

        Assertions.assertEquals("Repository [branches=" + Arrays.toString(repository.getBranches().toArray())
                + "]", repository.toString());
        Assertions.assertEquals("Branch [name=" + branch.getName()
                + ", commits=" + Arrays.toString(branch.getCommits().toArray())
                + "]", branch.toString());
        Assertions.assertEquals("Commit [diff=" + commit.getDiff()
                + ", message=" + commit.getMessage()
                + ", author=" + commit.getAuthor()
                + ", time=" + commit.getTime()
                + ", hash=" + commit.getHash()
                + "]", commit.toString());
    }
}