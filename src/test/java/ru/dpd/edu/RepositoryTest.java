package ru.dpd.edu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.dpd.edu.core.Branch;
import ru.dpd.edu.core.Commit;
import ru.dpd.edu.core.Repository;

import java.util.Arrays;
import java.util.NoSuchElementException;

class RepositoryTest {
    @Test
    public void test_addBranch() {
        Repository repo = new Repository();
        Branch branch = new Branch("master");
        repo.addBranch(branch);

        Assertions.assertTrue(repo.getBranches().contains(branch));
    }

    @Test
    public void test_addBranch_negative() {
        Repository repo = new Repository();
        String branchName = "master";
        Branch firstBranch = new Branch(branchName);
        repo.addBranch(firstBranch);

        Assertions.assertThrows(IllegalStateException.class,
                () -> repo.addBranch(new Branch(branchName)));
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

    @Test
    public void test_removeCommit() {
        Branch branch = new Branch("master");
        Commit firstCommit = new Commit("diff", "message", "Van'ka");
        Commit secondCommit = new Commit("diff", "message", "Leshka");
        branch.addCommit(firstCommit);
        branch.addCommit(secondCommit);
        branch.removeCommit(firstCommit.getHash());

        Assertions.assertFalse(branch.getCommits().contains(firstCommit));
    }

    @Test
    public void test_removeCommit_negative() {
        Branch branch = new Branch("master");
        Commit commit = new Commit("diff", "message", "Van'ka");
        branch.addCommit(commit);

        Assertions.assertThrows(
                NoSuchElementException.class,
                () -> branch.removeCommit(123));
    }

    @Test
    public void test_findCommitByAuthor() {
        Repository repository = new Repository();
        Branch branch = new Branch("master");
        Commit firstCommit = new Commit("diff", "message", "Vano");
        String expectedAuthor = "Petro";
        Commit secondCommit = new Commit("diff", "message", expectedAuthor);
        Commit thirdCommit = new Commit("diff", "message", "Sergo");
        branch.addCommit(firstCommit);
        branch.addCommit(secondCommit);
        branch.addCommit(thirdCommit);
        repository.addBranch(branch);

        Assertions.assertEquals(secondCommit, repository.findCommitByAuthor(expectedAuthor));
    }

    @Test
    public void test_findCommitByAuthor_negative() {
        Repository repository = new Repository();
        Branch branch = new Branch("master");
        Commit commit = new Commit("diff", "message", "Vano");
        branch.addCommit(commit);
        repository.addBranch(branch);

        Assertions.assertThrows(NoSuchElementException.class,
                () -> Assertions.assertEquals(commit, repository.findCommitByAuthor("error")));
    }
}