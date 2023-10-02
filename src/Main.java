import dataobj.Student;
import tables.AbsTable;
import tables.StudentTable;
import static tables.StudentTable.*;



public class Main {


    public static void main (String[] args){
        AbsTable studentTable = new StudentTable();
        StudentTable student1 = new Student("m",1,2, "Ilan");



            studentTable.drop();

        try {
            studentTable.create(COLUMNS);

            studentTable.insert(COLUMNS, student1.toString());
        } finally {
            studentTable.close();
        }

    }

}
