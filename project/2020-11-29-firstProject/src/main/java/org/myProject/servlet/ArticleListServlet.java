package org.myProject.servlet;

import org.myProject.dao.ArticleDAO;
import org.myProject.exception.AppException;
import org.myProject.model.Article;
import org.myProject.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@WebServlet("/articleList")
public class ArticleListServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp){
        //获取session，如果没有返回null
        HttpSession session=req.getSession(false);

        if(session==null){
            throw new AppException("ART002","用户未登录，不可访问！");
        }
        //获取登录时，创建的session保存的用户信息
        User user=(User)session.getAttribute("user");
        if(user==null){
            throw new AppException("ART003","会话异常请重新登录");
        }
        //登录后的操作，已保存用户信息
        List<Article> articles= ArticleDAO.queryByUserId(user.getId());
        return articles;
    }
}
