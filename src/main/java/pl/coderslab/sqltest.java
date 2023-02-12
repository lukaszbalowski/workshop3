package pl.coderslab;

import pl.coderslab.utils.DbUtil;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet(name = "sqltest", value = "/sqltest")
public class sqltest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        try (Connection connect = DbUtil.getConnection()) {

            response.getWriter().append("Połączono z bazą danych");


        } catch (SQLException e) {

            response.getWriter().append("Błąd połączenia z bazą danych" + e.getStackTrace());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
