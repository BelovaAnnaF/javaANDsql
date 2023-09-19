package dataobj;

import tables.StudentTable;

public class Student extends StudentTable {
    public int id;
    public int id_group;
    public String fio;
    public String sex;

    public Student(int id, int id_group, String fio, String sex) {
        this.id = id;
        this.id_group = id_group;
        this.fio = fio;
        this.sex = sex;
    }

    public int getId() {
        return id;
    }

    public int getId_group() {
        return id_group;
    }

    public String getFio() {
        return fio;
    }

    public String getSex() {
        return sex;
    }
}
