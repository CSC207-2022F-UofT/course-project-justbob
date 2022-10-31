package AccountClasses;

import java.util.List;

public class AccountInteractor{
    public void createAccount(){
        String id = (String) credentialsInput().get(0);
        String password = (String) credentialsInput().get(0);
        if(AccountList.accounts.contains(id)){
            /**return repetitive username and ask user for new input**/
        }
    }

    public List credentialsInput(){
        /**ask user for username and password**/
        /**return user input of id and password**/
    }
}
