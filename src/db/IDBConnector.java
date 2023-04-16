package db;

import java.sql.ResultSet;

public interface IDBConnector {
    void execeteRequest(String request);
    ResultSet execete(String request);
    void close();
}
