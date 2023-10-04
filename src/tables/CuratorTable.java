package tables;

import dataobj.Curator;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CuratorTable extends AbsTable{
    private final static String TABLE_NAME = "Curator";
    public static Map<String, String> COLUMNCURATOR = new HashMap<String, String>() {{
        put("id", "int");
        put("fio", "TEXT");
    }};
    public CuratorTable() {
        super(TABLE_NAME);
    }

}
