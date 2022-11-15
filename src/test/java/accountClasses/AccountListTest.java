package accountClasses;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountListTest {
    private Account goodAccount1 = new Account("Bobby001", "goodbob1998");
    private Account duplicateAccount = new Account("Bobby001", "goodbob1997");
    private Account shortIdAccount = new Account("Bob", "goodbob1996");
    private Account longIdAccount = new Account("BooooooobIsLoooong", "goodbob1995");
    private Account getGoodAccount2 = new Account("Jimmy001", "badjim2022");

    @Test
    public void addAccount(){
        AccountList.addAccount(goodAccount1);
        Assertions.assertEquals(AccountList.accounts, List.of(new Account("Bobby001", "goodbob1998")));
    }

    @Test
    public void duplicateCheckTrue()

    @Test
    public void duplicateCheckFalse()

    @Test
    public void idCheckTrue()

    @Test
    public void idCheckFalseLong()

    @Test
    public void idCheckFalseShort()
}
