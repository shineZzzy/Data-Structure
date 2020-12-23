package org.myProject.servlet;

import org.myProject.dao.ArticleDAO;
import org.myProject.model.Article;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/articleDetail")
public class ArticleDetailSevlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //解析请求数据
        String id = req.getParameter("id");
        Article a = ArticleDAO.query(Integer.parseInt(id));
        return a;

    }
}
