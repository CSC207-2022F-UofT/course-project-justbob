import inMemoryDB.InMemoryEntityFactory;
import inMemoryDB.InMemoryEntityGateway;
import ports.database.EntityFactory;
import ports.database.EntityGateway;
import ports.usecases.account.viewSemester.ViewSemesterResponse;
import ports.usecases.account.addAccount.AddAccountRequest;
import ports.usecases.account.loginAccount.LoginAccountRequest;
import usecases.account.AddAccount.AddAccountUseCase;
import usecases.account.LoginAccount.LoginAccountUseCase;
import views.LoginView;
import views.SemesterView;

public class Main {
    private static final String DATABASE_FILE_PATH =
            "src/main/java/database_file.json";

    private static final EntityGateway entityGateway = new InMemoryEntityGateway(DATABASE_FILE_PATH);
    private static final EntityFactory entityFactory = new InMemoryEntityFactory();

    public static void main(String[] args) {
        String tempUsername = "Bob";
        String tempPassword = "password1";

        // TODO: Change back to LoginView
        new LoginView(entityGateway, entityFactory);

        // CREATE TEMPORARY USER IF THEY DON'T EXIST YET
        /*if (!entityGateway.existsAccount("Bob")) {
            AddAccountRequest accountRequest = new AddAccountRequest(tempUsername, tempPassword, tempPassword);
            AddAccountUseCase usecase = new AddAccountUseCase(entityGateway, entityFactory);
            usecase.execute(accountRequest);
        }*/

        // LOGIN TO TEMPORARY USER
        /*LoginAccountUseCase loginAccountUseCase = new LoginAccountUseCase(entityGateway);
        ViewSemesterResponse response = loginAccountUseCase.execute(new LoginAccountRequest(tempUsername, tempPassword));

        new SemesterView(entityGateway, entityFactory, response, null);*/
    }
}
