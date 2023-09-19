package tables;


import java.util.*;

public class StudentTable extends AbsTable{
    private final static String TABLE_NAME = "Student";
    public final static Map<String, String> COLUMNS = new HashMap<String, String>() {{
        put("id", "int");
        put("fio", "varchar(50)");
        put("sex", "varchar(50)");
        put("id_group", "int");
    }};

    public StudentTable() {
        super(TABLE_NAME);
    }

    public final static List<String> VALUES =Arrays.asList("sex","fio","id","id_group");//надо понять почему не полуаю эти данные в мэйн
    public final static List<String> INSERTVALUES = Arrays.asList("('m','Ivan',1,2)", "('w','Sveta',2,3)");//надо понять почему не полуаю эти данные в мэйн
}
