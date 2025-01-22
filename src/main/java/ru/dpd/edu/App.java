package ru.dpd.edu;

import ru.dpd.edu.core.Branch;
import ru.dpd.edu.core.Commit;
import ru.dpd.edu.core.Repository;

public class App {
    public static void main(String[] args) {
        Repository repository = new Repository();
        Branch branch = new Branch("lesson-5");
        repository.addBranch(branch);

        Commit commit = new Commit("diff", "init", "Nokichi");
        branch.addCommit(commit);
    }
}
