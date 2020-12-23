package org.myProject.dao;

import org.myProject.exception.AppException;
import org.myProject.model.Article;
import org.myProject.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ArticleDAO {
    public static List<Article> queryByUserId(Integer userId) {
        //允许返回空list
        List<Article> articles=new ArrayList<>();
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            c=DBUtil.getConnection();
            String sql="select id,title from article where user_id=?";
            ps=c.prepareStatement(sql);
            //设置占位符
            ps.setInt(1,userId);

            rs=ps.executeQuery();
            while (rs.next()){
                Article a=new Article();
                //从结果集取值设置到文章对象
                a.setId(rs.getInt("id"));
                a.setTitle(rs.getString("title"));
                articles.add(a);
            }
            return articles;
        } catch (Exception e) {
            throw new AppException("ART001","查询文章列表出错",e);
        } finally {
            DBUtil.close(c,ps,rs);
        }
    }

    public static int delete(String[] split) {
        Connection c=null;
        PreparedStatement ps=null;

        try {
            c=DBUtil.getConnection();
            StringBuilder sql=new StringBuilder("delete from article where id in (");
            for(int i=0;i<split.length;i++){
                if(i!=0) {
                    sql.append(",");
                }
                sql.append("?");
                //(?,?,?)
            }
            sql.append(")");
            ps=c.prepareStatement(sql.toString());
            //设置占位符
            for(int i=0;i<split.length;i++){
                ps.setInt(i+1,Integer.parseInt(split[i]));
            }
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new AppException("ART004","删除文章列表出错",e);
        } finally {
            DBUtil.close(c,ps);
        }

    }

    public static int insert(Article a) {
        Connection c=null;
        PreparedStatement ps=null;
        try {
            c=DBUtil.getConnection();
            String sql="insert into article (title,content,user_id)"+"value (?,?,?)";
            ps=c.prepareStatement(sql);
            //设置占位符
            ps.setString(1,a.getTitle());
            ps.setString(2,a.getContent());
            ps.setInt(3,a.getUserId());
            return ps.executeUpdate();
        } catch (Exception e) {
            throw new AppException("ART005","插入文章列表出错",e);
        } finally {
            DBUtil.close(c,ps);
        }
    }

    public static Article query(int id) {
        Connection c=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            c=DBUtil.getConnection();
            String sql="select id,title,content from article where id=?";
            ps=c.prepareStatement(sql);
            //设置占位符
            ps.setInt(1,id);

            ;
            rs=ps.executeQuery();
            Article a=null;
            while (rs.next()){
                a=new Article();
                //根据结果集设置文章属性
                a.setId(id);
                a.setTitle(rs.getString("title"));
                a.setContent(rs.getString("content"));

            }
            return a;
        } catch (Exception e) {
            throw new AppException("ART006","查询文章详情出错",e);
        } finally {
            DBUtil.close(c,ps);
        }
    }

    public static int update(Article a) {
        Connection c=null;
        PreparedStatement ps=null;

        try {
            c=DBUtil.getConnection();
            String sql="update article set title=?,content=? where id=?";
            ps=c.prepareStatement(sql);
            //设置占位符
            ps.setString(1,a.getTitle());
            ps.setString(2,a.getContent());
            ps.setInt(3,a.getId());

            return ps.executeUpdate();
        } catch (Exception e) {
            throw new AppException("ART007","修改文章出错",e);
        } finally {
            DBUtil.close(c,ps);
        }
    }
}
