package dataobj;

import tables.StudentTable;

import java.util.Map;

public class Student extends StudentTable {
    public int id;
    public int id_group;
    public String fio;
    public String sex;

    public Student(String sex, int id, int id_group, String fio) {
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

    @Override
    public String toString() {
        return String.format("('%s', %d, %d, '%s')", getSex(), getId(), getId_group(), getFio());
    }
}
