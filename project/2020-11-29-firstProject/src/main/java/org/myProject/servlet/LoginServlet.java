package org.myProject.servlet;

import org.myProject.dao.LoginDAO;
import org.myProject.exception.AppException;
import org.myProject.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends AbstractBaseServlet {
    @Override
    protected Object process(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        //获取请求数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        //先查询出一个用户，映射？

        User user= LoginDAO.query(username);
        if(user==null){
            throw new AppException("Log002","用户不存在");
        }
        //有可能空指针异常，不能反
        if(!user.getPassword().equals(password)){
            throw new AppException("Log003","用户名或密码错误");
        }
        //会话管理？？？
        HttpSession session=req.getSession();
        session.setAttribute("user",user);
        return null;

//        if("abc".equals(username)){
////            resp.sendRedirect("jsp/articleList.jsp");
//            return null;
//        }else {
//            //错误码：自定义LOG007，排查错误
//            //登陆错误
//            throw new AppException("LOG007","用户名/密码出错");
//
//        }
    }
}
