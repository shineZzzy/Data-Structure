package JDBC2.testDmo;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class work5 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement preSt=null;

        try {
            //1.创建连接
            MysqlDataSource ds=new MysqlDataSource();
            ds.setUrl("jdbc:mysql://localhost:3306/mywork?user=root&password=MYsql123!&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            connection=ds.getConnection();
            System.out.println(connection);
            //2.创建操作命令
            //SQL语句
            String sql="update book set price=? where name='深入理解Java虚拟机'";
            //预编译
            preSt=connection.prepareStatement(sql);
            //赋值
            preSt.setDouble(1,61.20);
            //执行
            int r=preSt.executeUpdate();
            if(r>0){
                System.out.println("修改成功！");
                System.out.println(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("修改出错了", e);
        } finally {
            try {
                if (preSt != null)
                    preSt.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
