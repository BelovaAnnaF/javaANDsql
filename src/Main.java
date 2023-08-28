import db.DBConnector;
import db.IDBConnector;
import tables.AbsTable;
import tables.StudentTable;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, String> studentColumns = new HashMap<String, String>() {{
        put("id", "int");
        put("name", "varchar(50)");
        put("sex", "varchar(50)");
        put("id_group", "int");
    }};

    public static void main (String[] args){
        AbsTable studentTable = new StudentTable();

            studentTable.drop();

        try {
            studentTable.create(studentColumns);
        } finally {
            studentTable.close();
        }
    }

}
