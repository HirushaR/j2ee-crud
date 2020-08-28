package servlet;

import dao.UserAcess;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "login",urlPatterns = "/login")
public class login extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        String psw = request.getParameter("password");


        try {
            User u = new User(name,psw);
            UserAcess us = new UserAcess();
            if(us.login(u))
            {
                RequestDispatcher rd = request.getRequestDispatcher("/AddNew.jsp");
                rd.forward(request,response);
            }else {
                out.print("<p style=\"color:red\">Sorry username or password error</p>");
                RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
                rd.include(request,response);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
