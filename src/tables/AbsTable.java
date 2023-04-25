package tables;

import db.DBConnector;
import db.IDBConnector;

import java.util.Map;
import java.util.stream.Collectors;

public abstract class AbsTable {
    private IDBConnector idbConnector = new DBConnector();

    private String tableName;
    private Map<String, String> columns;

    public AbsTable(String tableName, Map<String, String> columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    private String convertMapColumnsToString(Map<String, String> columns) {
        return columns.entrySet().stream()
                .map((Map.Entry entry) -> String.format("%s %s", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(", "));
    }

    public void create() {
        String sqlRequest = String.format("create table %s (%s);", this.tableName, convertMapColumnsToString(this.columns));
        idbConnector.execeteRequest(sqlRequest);
    }

}
