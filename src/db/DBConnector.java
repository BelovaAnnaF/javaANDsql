package db;

import java.sql.*;

public class DBConnector implements IDBConnector{

    private static Connection connection = null;
    private static Statement statement = null;

    public DBConnector() {
        connect();
    }

    private void  connect() {
        if (connection == null) {
            connection = DriverManager.getConnection();
        }

        if (statement == null) {
            try {
                connection.createStatement();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public ResultSet execete(String request)  {
        try {
            return statement.executeQuery(request);
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    @Override
    public void execeteRequest(String request) {
        try {
            statement.execute(request);
        } catch(SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void close() {
        if (statement != null){
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        if (connection != null) {
               try {
                   connection.close();
               } catch (SQLException ex) {
                   ex.printStackTrace();
               }
           }
    }
}
