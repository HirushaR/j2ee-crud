package DB;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {

    public static PreparedStatement GetPreparedStatement(String sql) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/test?useSSL=false";
        String user = "root";
        String pass = "";

        Connection con = DriverManager.getConnection(url,user,pass);
        ps = con.prepareStatement(sql);

        return ps;
    }

    // check connection
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        GetPreparedStatement("select * from news");
    }
}
