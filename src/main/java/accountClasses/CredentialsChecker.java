package accountClasses;

public class CredentialsChecker {

    public static boolean checkDuplicateId(String id){
        //Check if the given username matches an existing username in accounts
        for(Account account : AccountList.accounts){
            if(account.getUsername().equals(id)){
                return false;
            }
        }
        return true;
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
