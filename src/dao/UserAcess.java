package dao;

import DB.DBUtil;
import model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAcess {

    public boolean login(User u) throws SQLException, ClassNotFoundException {
        ResultSet rs = null;
        PreparedStatement ps = DBUtil.GetPreparedStatement("select * from user where username = ? and password = ?");
        ps.setString(1,u.getUserName());
        ps.setString(2,u.getPassWord());
        rs = ps.executeQuery();
        while (rs.next())
        {
            return true;
        }
        return false;
    }
}
