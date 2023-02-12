package pl.coderslab;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserAdd", value = "/user/add")
public class UserAdd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/userAdd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String characterEncoding = "UTF-8";
        request.setCharacterEncoding(characterEncoding);
        response.setCharacterEncoding(characterEncoding);

            User user = new User();
            user.setUserName(request.getParameter("userName"));
            user.setEmail(request.getParameter("userEmail"));
            user.setPassword(request.getParameter("userPassword"));
            UserDao userDao = new UserDao();
            userDao.create(user);
            response.sendRedirect("/userslist.jsp");


        }

    }

