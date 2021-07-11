package JDBC2.testDmo;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.*;

public class work4 {
    public static void main(String[] args) {
        Connection connection=null;
        PreparedStatement prest=null;
        ResultSet resultSet=null;

        try {
            //1.连接数据库
            MysqlDataSource ds= new MysqlDataSource();
            ds.setUrl("jdbc:mysql://localhost:3306/mywork?user=root&password=MYsql123!&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            connection=ds.getConnection();
            System.out.println(connection);
            //2.执行sql
            String sql="select bo.name book_name,stu.name student_name,borrow_info.start_time,borrow_info.end_time\n" +
                    "from \n" +
                    "    borrow_info\n" +
                    "join book bo on borrow_info.book_id=bo.id\n" +
                    "join category cate on bo.category_id=cate.id\n" +
                    "join students stu on borrow_info.student_id=stu.id\n" +
                    "where cate.id=?";
            //预编译
            prest=connection.prepareStatement(sql);
            //赋值
            prest.setInt(1,3);
            //执行
            resultSet=prest.executeQuery();
            //处理结果集
            while (resultSet.next()){
                String bookName=resultSet.getString("book_name");
                String stuName=resultSet.getString("student_name");
                Timestamp startTime=resultSet.getTimestamp("start_time");
                Timestamp endTime=resultSet.getTimestamp("end_time");

                System.out.printf("bookName = %s ; stuName = %s ; startTime = %s ; endTime = %s ;",bookName,stuName,startTime,endTime);
            }
        } catch (Exception throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                if(resultSet!=null){
                    resultSet.close();
                }
                if (prest != null) {
                    prest.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("查询信息出错了", e);
            }
        }
    }
}
