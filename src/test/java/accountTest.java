import entities.account.Account;
import inMemoryDB.InMemoryEntityFactory;
import inMemoryDB.InMemoryEntityGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.account.addAccount.AddAccountRequest;
import ports.usecases.account.loginAccount.LoginAccountRequest;
import ports.usecases.account.loginAccount.LoginAccountResponse;
import usecases.account.AddAccountUseCase;
import usecases.account.LoginAccountUseCase;

public class accountTest {
    private EntityGateway entityGateway;
    private EntityFactory entityFactory;

    @Test
    public void AddAccountTest(){
        this.entityGateway = new InMemoryEntityGateway();
        this.entityFactory = new InMemoryEntityFactory();
        AddAccountUseCase myUseCase = new AddAccountUseCase(entityFactory, entityGateway);
        AddAccountRequest request = new AddAccountRequest("55555555", "10101010");
        myUseCase.execute(request);
        Assertions.assertEquals("10101010", entityGateway.loadAccount("55555555").getPassword());
    }

    @Test
    public void LoginAccountTest(){
    }
}
