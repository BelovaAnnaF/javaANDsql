package db;

import java.sql.*;

public class DBConnector implements IDBConnector{

    private static Connection connection = null;

    public DBConnector() {
        connect();
    }

    private void  connect() {
        if (connection == null) {
            connection = DriverManager.getConnection();
        }
    }

    @Override
    public ResultSet execete(String request)  {
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(request);
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void execeteRequest(String request) {

    }

    @Override
    public void close() {

    }
}
