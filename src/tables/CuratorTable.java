package tables;

import java.util.HashMap;
import java.util.Map;

public class CuratorTable extends AbsTable{
    private final static String TABLE_NAME = "Curator";
    public static Map<String, String> COLUMNS = new HashMap<String, String>() {{
        put("id", "int");
        put("fio", "varchar(50)");
    }};
    public CuratorTable() {
        super(TABLE_NAME);
    }
}
