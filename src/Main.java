import dataTables.Student;
import tables.AbsTable;

import java.util.*;

public class Main {
    private static Map<String, String> studentColumns = new HashMap<String, String>() {{
        put("id", "int");
        put("fio", "varchar(50)");
        put("sex", "varchar(50)");
        put("id_group", "int");
    }};
    private static List<String> studentValues = Arrays.asList("sex","fio","id","id_group");

    public static void main (String[] args){
        AbsTable studentTable = new Student();


            studentTable.drop();

        try {
            studentTable.create(studentColumns);

            studentTable.insert((studentValues), ("('m','Ivan',1,2), ('w','Sveta',2,3)"));
        } finally {
            studentTable.close();
        }

    }

}
