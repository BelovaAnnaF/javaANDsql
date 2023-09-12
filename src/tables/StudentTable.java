package tables;


import java.util.List;

public abstract class StudentTable extends AbsTable{
    private final static String TABLE_NAME = "Student";

    public StudentTable() {
        super(TABLE_NAME);
    }
}
