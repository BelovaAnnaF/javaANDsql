package tables;

import db.DBConnector;
import db.IDBConnector;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class AbsTable {
    public IDBConnector idbConnector = new DBConnector();

    private String tableName="";

    public AbsTable(String tableName) {
        this.tableName = tableName;
    }
    private String convertMapColumnsToString(Map<String, String> columns) {
        List<String> columnsStr = new ArrayList<>();

        for(Map.Entry<String, String> entry: columns.entrySet()) {
            columnsStr.add(String.format("%s %s", entry.getKey(), entry.getValue()));
            }
        return String.join(", ", columnsStr);
    }
    public String convertColumnsNameToString(Map<String, String> columns){
        List<String> columnsName = new ArrayList<>();
        for(Map.Entry<String, String> entry: columns.entrySet()){
            columnsName.add(String.format("%s", entry.getKey()));
        }
        return String.join(", ", columnsName);
    }

    public void drop(){
        String sqlRequestDelete = String.format("drop table if exists %s;", this.tableName);
        idbConnector.execeteRequest(sqlRequestDelete);
    }

    public void create(Map<String, String> columns) {

        String sqlRequest = String.format("create table %s (%s);", this.tableName, convertMapColumnsToString(columns));
        idbConnector.execeteRequest(sqlRequest);
    }

    public void insert(Map<String, String> columns, String values){
        String sqlRequestInsert = String.format("insert into %s (%s) values %s;", this.tableName,
                convertColumnsNameToString(columns), values);
        idbConnector.execeteRequest(sqlRequestInsert);
    }


    public void close() {
        idbConnector.close();    }


}
