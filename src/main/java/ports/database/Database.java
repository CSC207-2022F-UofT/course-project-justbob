package ports.database;

public interface Database {
    EntityFactory getEntityFactory();
    EntityGateway getEntityGateway();
}
