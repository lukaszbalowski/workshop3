package pl.coderslab;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {


    public static void main(String[] args) {

        try (Connection connect = DbUtil.connectUsers()) {

            System.out.println("połączony");


        } catch (SQLException e) {

            System.out.println( "błąd połączenia z bazą" + e.getStackTrace());
        }

    }

}
