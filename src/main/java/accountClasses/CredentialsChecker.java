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

    public static boolean requirementsCheck(String input) {
        return !(8 <= input.length() && input.length() <= 16);
    }
}
