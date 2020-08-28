package dao;
import DB.DBUtil;
import com.sun.xml.internal.ws.api.streaming.XMLStreamWriterFactory;
import model.News;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DataAccess {
    public  void addNew(News n) throws SQLException, ClassNotFoundException {
        PreparedStatement ps = DBUtil.GetPreparedStatement("insert into news values(?,?,?,?)");
        ps.setInt(1,0);
        ps.setString(2,n.getName());
        ps.setString(3,n.getSchool());
        ps.setInt(4,n.getAge());


        ps.executeUpdate();
    }

    public static List<News> GetAll() throws SQLException, ClassNotFoundException {
        List<News> ls = new LinkedList<>();
        ResultSet rs = DBUtil.GetPreparedStatement("select * from news").executeQuery();
        while (rs.next())
        {
            News n = new News(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            ls.add(n);
        }
        return  ls;
    }

    public static List<News> GetNewsById(int id) throws SQLException, ClassNotFoundException {
        List<News> ls = new LinkedList<>();
        String sql = "select * from news where id = " + id;
        ResultSet rs = DBUtil.GetPreparedStatement(sql).executeQuery();
        while (rs.next())
        {
            News n = new News(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4));
            ls.add(n);
        }
        return  ls;
    }

    public void edit(News n) throws SQLException, ClassNotFoundException {
        String sql = "update news set name = ?, school= ?, age = ? where id = ?";
        PreparedStatement ps =DBUtil.GetPreparedStatement(sql);
        ps.setString(1,n.getName());
        ps.setString(2,n.getSchool());
        ps.setInt(3,n.getAge());
        ps.setInt(4,n.getId());
        ps.executeUpdate();

    }

    public void delete(int id) throws SQLException, ClassNotFoundException {
        String sql ="delete from news where id = ?";
        PreparedStatement ps =DBUtil.GetPreparedStatement(sql);
        ps.setInt(1,id);
        ps.executeUpdate();

    }


}
