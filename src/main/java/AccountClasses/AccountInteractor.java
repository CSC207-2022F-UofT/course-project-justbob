package AccountClasses;

import java.util.*;

public class AccountInteractor{
    public void createAccount(){
        String id = idInput();
        for(Account account : AccountList.accounts){
            if(Objects.equals(account.username, id)){
                System.out.println("Username already exists, please choose another username");
                createAccount();
            } else{
                String password = passwordCheck();
                Account newAcc = new Account(id, password);
                AccountList.addAccount(newAcc);
                System.out.println("Account has been successfully created");
            }
        }

    }

    private String idInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Username");
        return input.nextLine();
    }
    private String passwordInput(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Password (8-16 characters, alphabets and numbers only)");
        return input.nextLine();
    }

    private String passwordCheck(){
        String password = passwordInput();
        if(8 <= password.length() && password.length() <= 16){
            return password;
        }else {
            System.out.println("Invalid password,password must be between 8 to 16 characters");
            passwordCheck();
        }
        return password;
    }

    public void removeAccount(Account account){
        AccountList.removeAccount(account);
    }
}
