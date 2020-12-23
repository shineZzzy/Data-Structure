package org.myProject.servlet;

import org.myProject.dao.ArticleDAO;
import org.myProject.model.Article;
import org.myProject.model.User;
import org.myProject.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.InputStream;

@WebServlet("/articleAdd")
public class ArticleAddServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        HttpSession session=req.getSession(false);
        User user=(User) session.getAttribute("user");
        //请求数据类型是Application.json，需要输入流获取
        InputStream is=req.getInputStream();
        //反序列化成文章对象
        Article a= JSONUtil.deserialize(is,Article.class);
        a.setUserId(user.getId());
        int num= ArticleDAO.insert(a);
        return null;
    }
}
