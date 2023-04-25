package tables;

import java.util.HashMap;
import java.util.Map;

public class StudentTable extends AbsTable{
    private final static String TABLE_NAME = "Student";

    public StudentTable() {
        super(TABLE_NAME, columns);

        Map<String, String> columns = new HashMap<>();
        columns.put("name", "varchar(50)");
    }

}
