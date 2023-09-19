
import tables.AbsTable;
import tables.StudentTable;

import java.util.Arrays;
import java.util.List;

import static tables.StudentTable.*;


public class Main {


    public static void main (String[] args){
        AbsTable studentTable = new StudentTable();


            studentTable.drop();

        try {
            studentTable.create(COLUMNS);

            studentTable.insert(VALUES, INSERTVALUES);
        } finally {
            studentTable.close();
        }

    }

}
