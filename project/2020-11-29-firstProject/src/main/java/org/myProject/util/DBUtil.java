package org.myProject.util;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.myProject.exception.AppException;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/servlet_blog?user=root&password=MYsql123!&useUnicode=true&characterEncoding=UTF-8&useSSL=false";
    //创建连接池
    private static final DataSource DS=new MysqlDataSource();


    /**工具类提供JDBC操作
     * 不足：
     * 1.static代码块出现错误，
     * NoClassDefFoundError：类可以找到，
     * 但类加载失败，无法运行
     * ClassNotFoundException:找不到类
     * 2.多线程后，会采用双重校验锁的单例模式创建DataSource
     * 3.工具类设计上不是最优的，数据库ORM框架Mybatis,是模板模式设计的
     */
    static {
        ((MysqlDataSource) DS).setUrl(URL);
    }
    public static Connection getConnection(){
        try {
            return DS.getConnection();
        } catch (SQLException e) {
//            e.printStackTrace();
//            抛自定义异常 TODO
            throw new AppException("DB001","获取数据库连接失败！",e);

        }
    }
    //查询时才会用到ResultSet，增删改不需要，因此重载处理二种情况
    public static void close(Connection c,Statement s){
        close(c,s,null);
    }
    public static void close(Connection c, Statement s, ResultSet r){
        try {
            if(r!=null){
                r.close();
            }
            if (s!=null){
                s.close();
            }
            if(c!=null){
                c.close();
            }
        } catch (SQLException e) {
            throw new AppException("DB002","数据库释放资源出错");
        }
    }


}
