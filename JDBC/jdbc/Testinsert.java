package JDBC1;

import JDBC1.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Testinsert {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            //1.获取连接
            connection = JdbcUtils.getConnect();
            statement = connection.createStatement();
            //2.执行SQL
            String sql = "insert into student(id,sn,name,qq_mail,classes_id) " + "values(13,2022,'李三白','232222@qq.com',2)";
            int i = statement.executeUpdate(sql);
            if (i > 0) {
                System.out.println("插入成功！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.release(connection, statement, resultSet);
        }
    }

}
