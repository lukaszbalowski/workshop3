package org.example.utils;
import java.sql.*;

public class DbUtil {
    static String DB_URL = "jdbc:mysql://localhost:3306/products_ex?useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
    static String DB_USER = "root";
    static String DB_PASS = "coderslab";
    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL,DB_USER,DB_PASS);
    }

    public static Connection connectCinema() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/cinemas_ex?useSSL=false&characterEncoding=utf8&serverTimezone=UTC",
                "root",
                "coderslab");
    }


    public static Connection connectUsers() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/workshop2?useSSL=false&characterEncoding=utf8&serverTimezone=UTC",
                "root",
                "coderslab");
    }


    public static void insert(Connection conn, String query, String... params) {
        try ( PreparedStatement statement = conn.prepareStatement(query)) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void printData(Connection conn, String query, String... columnNames) throws SQLException {

        try (PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery();) {
            while (resultSet.next()) {
                for (String columnName : columnNames) {
                    System.out.println(resultSet.getString(columnName));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final String DELETE_QUERY = "DELETE FROM tableName where id = ?;";
    public static void remove(Connection conn, String tableName, int id) {
        try (PreparedStatement statement =
                     conn.prepareStatement(DELETE_QUERY.replace("tableName", tableName));) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void update(Connection conn, String query, int id, String... params) {
        try ( PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setInt(params.length+1, id);
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

