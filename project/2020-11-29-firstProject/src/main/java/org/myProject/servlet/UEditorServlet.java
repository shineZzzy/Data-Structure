package org.myProject.servlet;

import org.myProject.util.MyActionEnter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;

/**
 * ueditor富文本编辑器图片上传
 * 1.修改idea中的tomcat配置的应用上下文路径，maven中的finalName
 * 2.修改update/static/ueditor.confjg.js/ 33行
 * 应用上下文路径+服务器路径
 * 3.实现后端接口，和第二步服务器路径相同
 */
@WebServlet("/ueditor")
public class UEditorServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        URL url= UEditorServlet.class.getClassLoader().getResource("config.json");
        String path= URLDecoder.decode(url.getPath(),"UTF-8");
        MyActionEnter enter=new MyActionEnter(req,path);
        String exec=enter.exec();
        PrintWriter ps=resp.getWriter();
        ps.println(exec);
        ps.flush();
        ps.close();
    }
}
