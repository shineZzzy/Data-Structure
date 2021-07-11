package JDBC.test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class firDemo {
    public static void main(String[] args) {
        Connection connection= null;
        Statement statement= null;
        ResultSet resultSet= null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.创建连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?user=root&password=MYsql123!&useUnicode=true&characterEncoding=UTF-8&useSSL=false");
            System.out.println(connection);
            System.out.println("=========================================");
            //3.执行SQL对象
            //创建操作命令
            statement = connection.createStatement();
            //执行SQL语句,获得结果集
            String sql="select * from student";
            resultSet = statement.executeQuery(sql);
            //4.处理结果集
            //new一个Arraylist存放对象
            List<Stu> stuList=new ArrayList<>();
            //遍历
            //目的:取出个字段的名字以及他们的值并将其作为值赋给对应的实体对象的属性
            while (resultSet.next()){
                //遍历得到一行数据每个字段的值
                int id=resultSet.getInt("id");
                int sn=resultSet.getInt("sn");
                String name=resultSet.getString("name");
                String qqmail=resultSet.getString("qq_mail");
                int classes_id=resultSet.getInt("classes_id");
                System.out.printf("id = %s ,sn = %s ,name = %s ,qqmail = %s ,classes_id = %s%n",id,sn,name,qqmail,classes_id);
                System.out.println("================================================");
                //将一行数据转换为对象
                //将结果集映射为对象
                //利用反射将结果集中的字段名与实体对象中的属性名相对应
                //将值赋给对象的属性
                Stu stu=new Stu();
                stu.setId(id);
                stu.setSn(sn);
                stu.setName(name);
                stu.setQqmail(qqmail);
                stu.setClasses_id(classes_id);
                stuList.add(stu);

                //因为作用域在while循环中，所以遍历完也就失效了
                //需要存储在其他地方，ArrayList


//                stu.id=id;
//                stu.sn=sn;
//                stu.name=name;
//                stu.qqmail = qqmail;
//                stu.classes_id=classes_id;


            }
            System.out.println(" "+stuList);


        } catch (Exception e) {
            //捕获最顶级的异常
            //打印异常
            e.printStackTrace();
        } finally {
            //5.释放连接(无论如何)
            try {
                if(resultSet != null)
                    resultSet.close();
                if(statement != null)
                    statement.close();
                if(connection != null)
                    connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
//            if (resultSet != null) {
//                try {
//                    resultSet.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (statement != null) {
//                try {
//                    statement.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (connection != null) {
//                //为什么不直接使用：“connection.close()”
//                //1.假如在“connection = DriverManager.getConnection()”处就报错，
//                //connection可能为空???
//                //2.close自身也会抛异常
//                try {
//                    connection.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
    //静态内部类：自己的方法自己控制
    //对象的属性不提供对外直接修改
    /**
     * 1.如果用定义为其他方法，使用get/set方法
     * 2.构造方法设置
     */
    private static class Stu{
        private Integer id;
        private Integer sn;
        private String name;
        private String qqmail;
        private Integer classes_id;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getSn() {
            return sn;
        }

        public void setSn(Integer sn) {
            this.sn = sn;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getQqmail() {
            return qqmail;
        }

        public void setQqmail(String qqmail) {
            this.qqmail = qqmail;
        }

        public Integer getClasses_id() {
            return classes_id;
        }

        public void setClasses_id(Integer classes_id) {
            this.classes_id = classes_id;
        }

        @Override
        public String toString() {
            return "Stu{" +
                    "id=" + id +
                    ", sn=" + sn +
                    ", name='" + name + '\'' +
                    ", qqmail='" + qqmail + '\'' +
                    ", classes_id=" + classes_id +
                    '}';
        }
    }
}
