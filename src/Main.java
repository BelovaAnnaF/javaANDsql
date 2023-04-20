import db.DBConnector;
import db.IDBConnector;

public class Main {

    public static void main (String[] args){
        IDBConnector idbConnector = new DBConnector();
        idbConnector.execeteRequest("create table student columns (id int primary key, name varchar(500));");
    }

}
