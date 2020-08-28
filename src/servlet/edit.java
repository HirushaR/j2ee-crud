package servlet;

import dao.DataAccess;
import model.News;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "edit",urlPatterns = "/edit")
public class edit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String school = request.getParameter("school");
        int age = Integer.parseInt(request.getParameter("age"));


        try {
            News n = new News(id,name,school,age);
            DataAccess da = new DataAccess();
            da.edit(n);
            response.sendRedirect("/test01_war_exploded/AllPost");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            request.setAttribute("GetNewsById", DataAccess.GetNewsById(id));
            RequestDispatcher rd = request.getRequestDispatcher("/EditPost.jsp");
            rd.forward(request,response);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
