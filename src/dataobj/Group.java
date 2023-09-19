package dataobj;

import tables.GroupTable;

public class Group extends GroupTable {
    int id;
    String name;
    int id_curator;

    public Group(int id, String name, int id_curator) {
        this.id = id;
        this.name = name;
        this.id_curator = id_curator;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getId_curator() {
        return id_curator;
    }
}
