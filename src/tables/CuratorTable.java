package tables;

import java.util.HashMap;
import java.util.Map;

public class CuratorTable extends AbsTable{
    protected final static String TABLE_NAME = "Curator";
    public static Map<String, String> COLUMNCURATOR = new HashMap<String, String>() {{
        put("id", "int");
        put("fio", "TEXT");
    }};
    public CuratorTable() {
        super(TABLE_NAME);
    }

}
