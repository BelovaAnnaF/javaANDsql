package tables;

import db.DBConnector;
import db.IDBConnector;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbsTable {
    private IDBConnector idbConnector = new DBConnector();

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
    private String convertColumnsNameToString(Map<String, String> columns){
        List<String> columnsName = new ArrayList<>();
        for(Map.Entry<String, String> entry: columns.entrySet()){
            columnsName.add(String.format("%s", entry.getKey()));
        }
        return String.join(", ", columnsName);
    }
//    private String convertListInsertValueToString(String str){
//        return str = tableName.toString();
//    }

    public void drop(){
        String sqlRequestDelete = String.format("drop table if exists %s;", this.tableName);
        idbConnector.execeteRequest(sqlRequestDelete);
    }

    public void create(Map<String, String> columns) {

        String sqlRequest = String.format("create table %s (%s);", this.tableName, convertMapColumnsToString(columns));
        idbConnector.execeteRequest(sqlRequest);
    }

    public void insert(Map<String, String> columns){
            idbConnector.execete(String.format("insert into %s (%s) values %s;", this.tableName,
                convertColumnsNameToString(columns), tableName.toString()));
    }



    public void close() {
        idbConnector.close();
    }

}
