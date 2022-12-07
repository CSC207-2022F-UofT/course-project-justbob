import inMemoryDB.InMemoryEntityFactory;
import inMemoryDB.InMemoryEntityGateway;
import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.ApplicationResponse;
import ports.usecases.account.addAccount.AddAccountRequest;
import usecases.account.AddAccount.AddAccountController;
import usecases.account.AddAccount.AddAccountUseCase;
import views.ApplicationView;
import views.LoginView;

public class Main {
    private static final EntityGateway entityGateway = new InMemoryEntityGateway();
    private static final EntityFactory entityFactory = new InMemoryEntityFactory();

    public static void main(String[] args) {
        /*new LoginView(entityGateway, entityFactory);*/
        AddAccountRequest accountRequest = new AddAccountRequest("Bob", "password1", "password1");
        AddAccountUseCase usecase = new AddAccountUseCase(entityGateway, entityFactory);
        usecase.execute(accountRequest);
        ApplicationResponse tempResponse = new ApplicationResponse("Bob",
                "Semester 1",
                new String[]{},
                new String[]{},
                new Double[]{},
                null);
        new ApplicationView(entityGateway, entityFactory, tempResponse);
    }
}
