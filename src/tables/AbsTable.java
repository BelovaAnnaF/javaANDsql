package tables;

import db.DBConnector;
import db.IDBConnector;

import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbsTable {
    private IDBConnector idbConnector = new DBConnector();

    private String tableName;


    public AbsTable(String tableName) {
        this.tableName = tableName;
    }

    private String convertMapColumnsToString(Map<String, String> columns) {
        return columns.entrySet().stream()
                .map((Map.Entry entry) -> String.format("%s %s", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(", "));
    }

    public void drop(){
        String sqlRequestDelete = String.format("drop table if exists %s;", this.tableName);
        idbConnector.execeteRequest(sqlRequestDelete);
    }

    public void create(Map<String, String> columns) {

        String sqlRequest = String.format("create table %s (%s);", this.tableName, convertMapColumnsToString(columns));
        idbConnector.execeteRequest(sqlRequest);
    }

    public void close() {
        idbConnector.close();
    }

}
