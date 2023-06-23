package service;

import java.sql.*;

public class CrudRepository {

    public static void main(String[] args) throws SQLException {

        ResultSet resultSet = create("deneme2");
        ResultSet resultSet1 = read("umut");
        ResultSet resultSet2 = update("deneme2","umut","hope");

    }

    public static ResultSet create(String tableName) throws SQLException {
        // get connection to the database
        Connection conn = getConnect();

        // query in form of string -> creating a table with the name of tableName input
        String createsql = String.format("CREATE TABLE %s", tableName);

        // prepare statement for executing database query
        PreparedStatement preparedStatement = conn.prepareStatement(createsql);

        // run query and return the result set
        return preparedStatement.executeQuery();

    }

    public static ResultSet read(String read) throws SQLException {
        // get connection to the database
        Connection conn = getConnect();

        // query in form of string -> creating a table with the name of tableName input
        String createsql = String.format("select * from deneme2 where name = '%s'", read);

        // prepare statement for executing database query
        PreparedStatement preparedStatement = conn.prepareStatement(createsql);

        // run query and return the result set
        return preparedStatement.executeQuery(createsql);

    }
    public static ResultSet update(String tableName,String oldName, String newName) throws SQLException {
        // get connection to the database
        Connection conn = getConnect();

        // query in form of string -> creating a table with the name of tableName input
        String createsql = String.format("update %s set name='%s' where name='%s'", tableName,newName,oldName);

        // prepare statement for executing database query
        PreparedStatement preparedStatement = conn.prepareStatement(createsql);

        // run query and return the result set
        return preparedStatement.executeQuery(createsql);
    }
    public static ResultSet delete(String tableName, String name) throws SQLException {
        // get connection to the database
        Connection conn = getConnect();

        // query in form of string -> creating a table with the name of tableName input
        String createsql = String.format("delete from %s where name = '%s'", tableName,name);

        // prepare statement for executing database query
        PreparedStatement preparedStatement = conn.prepareStatement(createsql);

        // run query and return the result set
        return preparedStatement.executeQuery(createsql);
    }

    public static Connection getConnect() throws SQLException {
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/crudtest", "postgres", "123");
    }


}
