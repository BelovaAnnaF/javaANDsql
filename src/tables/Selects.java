package tables;


import db.DBConnector;
import db.IDBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Selects {
    protected IDBConnector idbConnector = new DBConnector();

//    Вывести на экран информацию о всех студентах включая название группы и имя куратора

    public ResultSet studentInfo() {

        ResultSet result = idbConnector.execete(String.format("select %1$s.Id, %1$s.FIO, SEX, " +
                "%2$s.name_group, %3$s.FIO as CuratorName from %1$s inner join %2$s on  %1$s.id_group = %2$s.Id " +
                "inner join %3$s on %2$s.id_curator = %3$s.Id;"
                , StudentTable.TABLE_NAME, GroupTable.TABLE_NAME, CuratorTable.TABLE_NAME));
                System.out.println("Полная информация по студентам");

        try {
            while (result.next()) {
                int id = result.getInt(1);
                String fio = result.getString(2);
                String sex = result.getString(3);
                String  name= result.getString(4);
                String curator = result.getString(5);
                System.out.println("StudentID: " + id + ", StudentName: " + fio + ", Sex: " + sex +
                        ", GroupName: " + name + ", CuratorName: " + curator + ";");
            }
        }catch (SQLException ex) {
                ex.printStackTrace();
            }
        return result;
    }
//    Вывести на экран количество студентов
    public ResultSet studentCount() {

    ResultSet result = idbConnector.execete(String.format("select count(Id) from %s;", StudentTable.TABLE_NAME));

    try {
        while (result.next()) {
            int count = result.getInt(1);
            System.out.println("Всего студентов: " + count);
        }
    }catch (SQLException ex) {
        ex.printStackTrace();
    }
    return result;
}
//    Вывести студенток
    public ResultSet studentWomen() {

    ResultSet result = idbConnector.execete(String.format("select id, FIO, sex, id_group from %s where sex = 'w' ;",
            StudentTable.TABLE_NAME));
        System.out.println("Список студенток:");

    try {
        while (result.next()) {
            int id = result.getInt(1);
            String fio = result.getString(2);
            String sex = result.getString(3);
            String id_group = result.getString(4);
            System.out.println("StudentID: " + id + ", StudentName: " + fio + ", Sex: " + sex + ", GroupID: " + id_group);
        }
    }catch (SQLException ex) {
        ex.printStackTrace();
    }
    return result;
}

//    Вывести список групп с их кураторами
    public ResultSet groupInfo() {

    ResultSet result = idbConnector.execete(String.format("select %1$s.id, name_group, %2$s.fio from %1$s inner join %2$s on %1$s.id_curator = %2$s.id;",
            GroupTable.TABLE_NAME, CuratorTable.TABLE_NAME));
    System.out.println("Список групп:");

    try {
        while (result.next()) {
            int id = result.getInt(1);
            String name = result.getString(2);
            String fio = result.getString(3);
            System.out.println("GroupID: " + id + ", GroupName: " + name + "CuratorName: " + fio);
        }
    }catch (SQLException ex) {
        ex.printStackTrace();
    }
    return result;
}
//    Используя вложенные запросы вывести на экран студентов из определенной группы(поиск по имени группы)
    public ResultSet studentFromGroup() {

    ResultSet result = idbConnector.execete(String.format("select id, FIO, sex, id_group from %s where id_group in (select id from %s where name_group = 'C');",
            StudentTable.TABLE_NAME, GroupTable.TABLE_NAME));
    System.out.println("Список студентов группы C:");

    try {
        while (result.next()) {
            int id = result.getInt(1);
            String fio = result.getString(2);
            String sex = result.getString(3);
            String id_group = result.getString(4);
            System.out.println("StudentID: " + id + ", StudentName: " + fio + ", Sex: " + sex + ", GroupID: " + id_group);
        }
    }catch (SQLException ex) {
        ex.printStackTrace();
    }
    return result;
}
}

