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
            studentTable.insert("sex, name, id, id_group","('m','Ivan',1,2), ('w','Sveta',2,3)");
        } finally {
            studentTable.close();
        }

    }

}
