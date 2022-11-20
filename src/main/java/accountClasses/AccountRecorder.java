package accountClasses;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class AccountRecorder {

    static public void addAccount(Account commonAccount) throws IOException {
        //This method adds a new account to the file that stores all accounts
        BufferedWriter out = new BufferedWriter(new FileWriter(new File("C:\\Users\\alanc\\IdeaProjects\\" +
                "course-project-justbob\\src\\main\\java\\accountClasses\\accountsStorage"), true));
        out.write(commonAccount.getUsername() + " " + commonAccount.getPassword());
        out.newLine();
        out.close();
    }
}
