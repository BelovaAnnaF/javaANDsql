import dataobj.Curator;
import dataobj.Group;
import dataobj.Student;
import tables.AbsTable;
import tables.CuratorTable;
import tables.GroupTable;
import tables.StudentTable;


import static tables.CuratorTable.*;
import static tables.GroupTable.*;
import static tables.StudentTable.*;



public class Main {


    public static void main (String[] args){
        AbsTable studentTable = new StudentTable();
        StudentTable student1 = new Student("w",1,2, "Ilana");
        StudentTable student2 = new Student("m",2,3, "Ivan");
        StudentTable student3 = new Student("m",3,2, "Stepan");
        StudentTable student4 = new Student("w",4,3, "Inna");
        StudentTable student5 = new Student("w",5,2, "Sveta");
        StudentTable student6 = new Student("w",6,3, "Rita");
        StudentTable student7 = new Student("m",7,2, "Vova");
        StudentTable student8 = new Student("m",8,3, "Ilya");
        StudentTable student9 = new Student("m",9,2, "Petr");
        StudentTable student10 = new Student("m",10,3, "Kir");
        StudentTable student11 = new Student("m",11,2, "Roma");
        StudentTable student12 = new Student("m",12,3, "Misha");
        StudentTable student13= new Student("m",13,2, "Tisha");
        StudentTable student14 = new Student("w",14,3, "Olga");
        StudentTable student15 = new Student("w",15,2, "Tim");

        AbsTable curatorTable = new CuratorTable();
        CuratorTable curator1 = new Curator(1,"Ivanich");
        CuratorTable curator2 = new Curator(2,"Petrovich");
        CuratorTable curator3 = new Curator(3,"Mitrich");
        CuratorTable curator4 = new Curator(4,"Ilay");

        AbsTable groupTable = new GroupTable();
        GroupTable group1 = new Group(1,"A", 3);
        GroupTable group2 = new Group(2,"B", 1);
        GroupTable group3 = new Group(3,"C", 2);

        studentTable.drop();
        curatorTable.drop();
        groupTable.drop();

        try {
            studentTable.create(COLUMNSUDENT);
            curatorTable.create(COLUMNCURATOR);
            groupTable.create(COLUMNGROUP);

            studentTable.insert(COLUMNSUDENT, student1.toString());
            studentTable.insert(COLUMNSUDENT, student2.toString());
            studentTable.insert(COLUMNSUDENT, student3.toString());
            studentTable.insert(COLUMNSUDENT, student4.toString());
            studentTable.insert(COLUMNSUDENT, student5.toString());
            studentTable.insert(COLUMNSUDENT, student6.toString());
            studentTable.insert(COLUMNSUDENT, student7.toString());
            studentTable.insert(COLUMNSUDENT, student8.toString());
            studentTable.insert(COLUMNSUDENT, student9.toString());
            studentTable.insert(COLUMNSUDENT, student10.toString());
            studentTable.insert(COLUMNSUDENT, student11.toString());
            studentTable.insert(COLUMNSUDENT, student12.toString());
            studentTable.insert(COLUMNSUDENT, student13.toString());
            studentTable.insert(COLUMNSUDENT, student14.toString());
            studentTable.insert(COLUMNSUDENT, student15.toString());

            curatorTable.insert(COLUMNCURATOR, curator1.toString());
            curatorTable.insert(COLUMNCURATOR, curator2.toString());
            curatorTable.insert(COLUMNCURATOR, curator3.toString());
            curatorTable.insert(COLUMNCURATOR, curator4.toString());

            groupTable.insert(COLUMNGROUP, group1.toString());
            groupTable.insert(COLUMNGROUP, group2.toString());
            groupTable.insert(COLUMNGROUP, group3.toString());

        } finally {
            studentTable.close();
            curatorTable.close();
            groupTable.close();
        }
    }

}
