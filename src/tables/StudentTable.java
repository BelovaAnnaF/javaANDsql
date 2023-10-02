package tables;
import dataobj.Student;

import java.util.*;

public class StudentTable extends AbsTable{
    private final static String TABLE_NAME = "Student";
    public final static Map<String, String> COLUMNS = new HashMap() {{
        put("id", "int");
        put("fio", "varchar(50)");
        put("sex", "varchar(50)");
        put("id_group", "int");
    }};

    public StudentTable() {
        super(TABLE_NAME);
    }



    /* public final static List<String> INSERTVALUES = Arrays.asList("('m',1,2,'Ivan')", "('w',2,3,'Sveta')"); */
}
