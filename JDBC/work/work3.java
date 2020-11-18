package JDBC2.testDmo;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class work3 {
    public static Timestamp getTime(String dateString){
        try {
            java.util.Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(dateString);
            return new Timestamp(date.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
            throw new  RuntimeException("日期格式化错误："+dateString, e);
        }
    }
    public static void main(String[] args) {
        System.out.println(insert());
    }

    public static int insert(){
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
            String sql="insert into borrow_info values(?,?,?,?,?)";
            //预编译
            preSt=connection.prepareStatement(sql);
            //赋值
            preSt.setInt(1,19);
            preSt.setInt(2,10);
            preSt.setInt(3,3);
            preSt.setTimestamp(4,getTime("2019-9-25 17:50:00"));
            preSt.setTimestamp(5,getTime("2019-10-25 17:50:00"));
            System.out.println(preSt);

            //执行
            int r=preSt.executeUpdate();
            if(r>0){
                System.out.println("插入成功！");
                System.out.println(r);
            }
            return r;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("插入出错了", e);
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
