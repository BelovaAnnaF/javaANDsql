package tables;

import dataobj.Student;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class StudentTable extends AbsTable{
    private final static String TABLE_NAME = "Student";
    public final static Map<String, String> COLUMNSUDENT = new HashMap() {{
        put("id", "int");
        put("fio", "TEXT");
        put("sex", "TEXT");
        put("id_group", "int");
    }};

    public StudentTable() {
        super(TABLE_NAME);
    }
}
