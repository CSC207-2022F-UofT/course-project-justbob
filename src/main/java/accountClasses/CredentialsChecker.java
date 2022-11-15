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

    public static boolean checkLength(String input){
        //check if the username or password is within 8 to 16 characters, inclusive
        return !(8 <= input.length() && input.length() <= 16);
    }
}
