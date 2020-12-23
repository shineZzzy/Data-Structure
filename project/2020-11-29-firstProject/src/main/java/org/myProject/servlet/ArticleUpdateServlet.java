package org.myProject.servlet;

import org.myProject.dao.ArticleDAO;
import org.myProject.model.Article;
import org.myProject.util.JSONUtil;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;

@WebServlet("/articleUpdate")
public class ArticleUpdateServlet extends AbstractBaseServlet{
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        InputStream is=req.getInputStream();
        Article a= JSONUtil.deserialize(is,Article.class);
        int num= ArticleDAO.update(a);
        return null;
    }
}
