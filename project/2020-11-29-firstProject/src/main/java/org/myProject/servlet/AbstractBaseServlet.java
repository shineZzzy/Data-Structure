package org.myProject.servlet;

import org.myProject.exception.AppException;
import org.myProject.model.JSONResponse;
import org.myProject.util.JSONUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public abstract class AbstractBaseServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req,
                         HttpServletResponse resp) throws ServletException,IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req,
                          HttpServletResponse resp) throws ServletException,IOException {

        //设置请求体的编码格式
        req.setCharacterEncoding("UTF-8");
        //设置响应体
        resp.setCharacterEncoding("UTF-8");
        //设置响应体数据类型（浏览器采取什么方式执行)
        resp.setContentType("application/json");

        //TODO
        JSONResponse json=new JSONResponse();
        try {
            //调用子类重写方法
            Object data=process(req, resp);
//            process(req, resp);
            //子类的process执行完成没有抛异常，表示业务执行成功
            json.setSuccess(true);
            json.setData(data);
        } catch (Exception e) {
            //异常处理
            e.printStackTrace();
            //json.success()不需要设置了，new的时候就是了？
            //将错误码和未知错误进行绑定
            String code="UNKNOWN";
            String s="未知错误";

            if(e instanceof AppException){
                code=((AppException) e).getCode();
                s=e.getMessage();
            }
            json.setCode(code);
            json.setMessage(s);
        }
        PrintWriter pw=resp.getWriter();
        pw.println(JSONUtil.serialize(json));
        pw.flush();
        pw.close();
    }

    //返回数据类型与data同
    protected abstract Object process(HttpServletRequest req,
                           HttpServletResponse resp) throws Exception;

}



