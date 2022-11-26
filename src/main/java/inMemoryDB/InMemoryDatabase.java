package inMemoryDB;

import ports.database.Database;
import ports.database.EntityFactory;
import ports.database.EntityGateway;

public class InMemoryDatabase implements Database {
    EntityFactory entityFactory = new InMemoryEntityFactory();
    EntityGateway entityGateway = new InMemoryEntityGateway();

    @Override
    public EntityFactory getEntityFactory() {
        return entityFactory;
    }

    @Override
    public EntityGateway getEntityGateway() {
        return entityGateway;
    }
}
