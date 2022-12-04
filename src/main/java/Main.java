import inMemoryDB.InMemoryEntityFactory;
import inMemoryDB.InMemoryEntityGateway;
import ports.database.EntityFactory;
import ports.database.EntityGateway;

public class Main {
    private static final EntityGateway entityGateway = new InMemoryEntityGateway();
    private static final EntityFactory entityFactory = new InMemoryEntityFactory();

    public static void main(String[] args) {
        new LoginForm(entityGateway, entityFactory);
    }
}
