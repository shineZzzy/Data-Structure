package JDBC1.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {

    private static String driver=null;
    private static String url=null;
    private static String username=null;
    private static String password=null;
    static {
        try{
            InputStream in=JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
            Properties properties = new Properties();

            properties.load(in);
            driver=properties.getProperty("driver");
            url=properties.getProperty("url");
            username=properties.getProperty("username");
            password=properties.getProperty("password");

            //1.加载驱动
            Class.forName(driver);

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    //2.获取连接
    public static Connection  getConnect() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
    //3.释放资源
    public static void release(Connection cnn, Statement st, ResultSet res){
        try {
            if(res != null)
                res.close();
            if(st!= null)
                st.close();
            if(cnn != null)
                cnn.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
