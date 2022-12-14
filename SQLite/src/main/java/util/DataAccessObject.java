package util;

import models.User;

import java.sql.Connection;
import java.util.List;

public abstract class DataAccessObject<T extends DataTransferObject> {
    protected final Connection connection;

    public DataAccessObject(Connection connection) {
        this.connection = connection;
    }

    public abstract User findById(long id);

    public abstract List<T> readAll();

    public abstract void create(T dto);

    public abstract void update(T dto);

    public abstract void delete(long id);
}
