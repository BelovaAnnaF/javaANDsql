package tables;

import java.util.HashMap;
import java.util.Map;

public class GroupTable extends AbsTable{
    private final static String TABLE_NAME = "Group";
    public static Map<String, String> COLUMNS = new HashMap<String, String>() {{
        put("id", "int");
        put("fio", "varchar(50)");
        put("sex", "varchar(50)");
        put("id_group", "int");
    }};
    public GroupTable() {
        super(TABLE_NAME);
    }
}
