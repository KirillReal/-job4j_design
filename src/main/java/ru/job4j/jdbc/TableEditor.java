package ru.job4j.jdbc;

import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable{

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) throws SQLException, ClassNotFoundException {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws ClassNotFoundException,SQLException {
        Class.forName("org.postgresql.Driver");
        connection = DriverManager.getConnection(
                properties.getProperty("url"),
                properties.getProperty("login"),
                properties.getProperty("password")
        );
    }

    public void createTable(String tableName) throws SQLException{
        System.out.printf("Create table %s",tableName);
        execute();
    }

    public void dropTable(String tableName) throws SQLException {
        System.out.printf("Drop table %s",tableName);
        execute();
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        System.out.printf("Alter table %s add column: %s",tableName,columnName);
        execute();
    }

    private void execute() throws SQLException {
            try (Statement statement = connection.createStatement()) {
                String sql = String.format(
                        "create table if not exists demo_table(%s, %s);",
                        "id serial primary key",
                        "name varchar(255)"
                );
                statement.execute(sql);
            }
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        System.out.printf("Alter table %s drop column: %s",tableName,columnName);
        execute();
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        System.out.printf("Alter table %s rename column %s to %s" ,tableName,columnName,newColumnName);
        execute();
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }
    @Override
    public void close() throws Exception {
        if(connection != null) {
            connection.close();
        }
    }
}
