package accountClasses;

import java.io.*;
import java.util.Objects;

public class CredentialsChecker {

    public static boolean checkDuplicateId(String id) throws IOException {
        //Check if the given username matches an existing username in accounts
        File file = new File("C:\\Users\\alanc\\IdeaProjects\\" +
                "course-project-justbob\\src\\main\\java\\accountClasses\\accountsStorage"); //file where all credentials are stored
        FileReader fReader = new FileReader(file);
        BufferedReader bReader = new BufferedReader(fReader);
        String line;
        while((line = bReader.readLine()) != null){ //checks each line, where each line is username + password, to see if any duplicates exist
            String[] sepLine = line.split(" ");
            if(Objects.equals(sepLine[0], id)){
                return true;
            }
        }
        return false;
    }

    public static boolean idLengthCheck(String input) {
        return 8 <= input.length() && input.length() <= 16;
    }
    //checks if the id(username) is between 8-16 characters, inclusive

    public static boolean passwordLengthCheck(String input) {
        return 8 <= input.length() && input.length() <= 16;
    }
    //checks if the password is between 8-16 characters, inclusive
}
