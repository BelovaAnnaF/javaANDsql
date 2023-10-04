package tables;

import dataobj.Curator;
import dataobj.Group;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupTable extends AbsTable{
    private final static String TABLE_NAME = "Grups";
    public static Map<String, String> COLUMNGROUP = new HashMap<String, String>() {{
        put("id", "int");
        put("name_group", "TEXT");
        put("id_curator", "int");
    }};
    public GroupTable() {
        super(TABLE_NAME);
    }
}
