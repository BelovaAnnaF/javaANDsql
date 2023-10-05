package tables;

import db.DBConnector;
import db.IDBConnector;

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
        String sqlRequest = String.format("drop table if exists %s;", this.tableName);
        idbConnector.execeteRequest(sqlRequest);
    }

//    Создать таблицу Student     Колонки id, fio, sex, id_group
//    Создать таблицу Group     Колонки id, name, id_curator
//    Создать таблицу Curator   Колонки id, fio
    public void create(Map<String, String> columns) {

        String sqlRequest = String.format("create table if not exists %s (%s);",
                this.tableName, this.convertMapColumnsToString(columns));
        idbConnector.execeteRequest(sqlRequest);
    }

//    Заполнить таблицы данными(15 студентов, 3 группы, 4 куратора)

    public void insert(Map<String, String> columns, String values){
        String sqlRequest = String.format("insert into %s (%s) values %s;", this.tableName,
                this.convertColumnsNameToString(columns), values);
        idbConnector.execeteRequest(sqlRequest);
    }

//    Обновить данные по группе сменив куратора

    public void update(String set, String query){
        String sqlRequest = String.format("update %s set %s where %s;", this.tableName,
                set, query);
        idbConnector.execeteRequest(sqlRequest);
    }

    public void close() {
        idbConnector.close();    }
}
