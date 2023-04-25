import db.DBConnector;
import db.IDBConnector;

public class Main {

    public static void main (String[] args){
        IDBConnector idbConnector = new DBConnector();
        try {
            idbConnector.execeteRequest("create table student (id int, name varchar(255));");
        } finally {
            idbConnector.close();
        }
    }

}
