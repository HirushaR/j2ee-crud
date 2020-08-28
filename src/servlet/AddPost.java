package servlet;

import dao.DataAccess;
import model.News;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "AddPost", urlPatterns = "/AddPost")
public class AddPost extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String school = request.getParameter("school");
        int age = Integer.parseInt(request.getParameter("age"));


        try {
            News n = new News(name,school,age);
            DataAccess da = new DataAccess();
            da.addNew(n);
            response.sendRedirect("/test01_war_exploded/AllPost");

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
