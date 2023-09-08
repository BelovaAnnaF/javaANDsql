package tables;

import db.DBConnector;
import db.IDBConnector;

import java.util.ArrayList;
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

//    public void delete() {
//        String sqlRequest = String.format("drop table %s", this.tableName);
//    }
    public void drop(){
        String sqlRequestDelete = String.format("drop table if exists %s;", this.tableName);
        idbConnector.execeteRequest(sqlRequestDelete);
    }

    public void create(Map<String, String> columns) {

        String sqlRequest = String.format("create table %s (%s);", tableName, convertMapColumnsToString(columns));
        idbConnector.execeteRequest(sqlRequest);
    }

    public void insert(String values, String insertValue){
        String sqlRequest = String.format("insert into %s (%s) values %s;", tableName, values, insertValue);
        idbConnector.execeteRequest(sqlRequest);
    }

    public void close() {
        idbConnector.close();
    }

}
