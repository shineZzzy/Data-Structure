package org.myProject.dao;

import org.myProject.exception.AppException;
import org.myProject.model.User;
import org.myProject.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {

    public static User query(String username) {
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        User user=null;

        try {
            c=DBUtil.getConnection();
            String sql="select id, username, password, " +
                    "nickname, sex, birthday, head from user " +
                    "where username=?";
            ps=c.prepareStatement(sql);
            //设置占位符
            ps.setString(1,username);
            rs=ps.executeQuery();
            while (rs.next()){
                user=new User();
                //设置user的值
                user.setId(rs.getInt("id"));
                user.setUsername(username);
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("nickname"));
                user.setSex(rs.getBoolean("sex"));
                //日期,一般使用util.Date(年月日时分秒)
                //rs.getDate()返回值是sql.Date(时分秒)
                //rs.getTimestamp()返回值是sql.Timestamp(年月日时分秒)
//                rs.getDate("birthday").getTime();
                java.sql.Date birthday=rs.getDate("birthday");
                if(birthday!=null) {
                    user.setBirthday(new Date(birthday.getTime()));
                }
                user.setHead(rs.getString("head"));
            }
            return user;
        } catch (Exception e) {
            //查后台堆栈报错信息
            throw new AppException("LoG001","查询用户操作出错",e);
        } finally {
            DBUtil.close(c,ps,rs);
        }

    }
}
