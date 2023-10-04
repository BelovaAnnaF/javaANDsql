package dataobj;

import tables.CuratorTable;

public class Curator extends CuratorTable {
    int id;
    String fio;

    public Curator(int id, String fio) {
        this.id = id;
        this.fio = fio;
    }

    public int getId() {
        return id;
    }

    public String getFio() {
        return fio;
    }
    @Override
    public String toString() {
        return String.format("(%d, '%s')", getId(), getFio());
    }
}
