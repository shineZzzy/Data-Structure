package org.myProject.filter;

import org.myProject.model.JSONResponse;
import org.myProject.util.JSONUtil;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 配置用户统一会话管理的过滤器，匹配所有请求路径
 * 服务端资源：/login不用校验Session,其他都要校验，若不通过，返回401，响应内容随意
 * 前端资源：/jsp/校验session，不通过重定向到登录页面
 *         /js/,/static/,/view/ 全部不校验
 */

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 每次http请求匹配到过滤器路径时，会执行该过滤器的doFilter
     * 如果是往后执行，是调用filterChain。doFilter(request,response)
     * 否则自行处理响应
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest) request;
        HttpServletResponse resp=(HttpServletResponse)response;
        //获取当前请求的服务路径，亦可静态资源
        String servletPath=req.getServletPath();
        //不需要登录允许访问的:继续调用
        //  /js/ ：可能js后还带有一些路径
        if(servletPath.startsWith("/js/")
                ||servletPath.startsWith("/static/")
                ||servletPath.startsWith("/view/")
                ||servletPath.equals("/login")){
            chain.doFilter(request, response);
        }else {
            //获取session对象，没有就返回null
            HttpSession session=req.getSession(false);
            //验证用户是否登录，若未登录，跳转还需要前后端做不同处理
            if(session==null || session.getAttribute("user")==null){
                //前端重定向到登录页，绝对路径
                if(servletPath.startsWith("/jsp/")){
                    resp.sendRedirect(basePath(req)+"/view/login.html");
                }else {
                    //后端返回401状态码🐎🐖🐂🐕🐱🐇
                     resp.setStatus(401);
                    resp.setCharacterEncoding("UTF-8");
                    resp.setContentType("application/json");
                    //返回统一的json格式
                    JSONResponse json=new JSONResponse();
                    json.setCode("LOG404");
                    json.setMessage("用户没有登录，不允许访问");
                    PrintWriter pw=resp.getWriter();
                    pw.println(JSONUtil.serialize(json));
                    pw.flush();
                    pw.close();
                }
            }else {
                //敏感资源，已经登录了，继续执行
                chain.doFilter(request, response);
            }
        }
    }

    /**
     *根据HTTP请求，动态的获取访问路径(服务路径之间的部分)
     */
    public static String basePath(HttpServletRequest rep){
        String schema= rep.getScheme();
        String host=rep.getServerName();//主机IP或域名
        int port=rep.getServerPort();//服务器端口号
        String contextPath=rep.getContextPath();//应用上下文路径
        return schema+"://"+host+":"+port+contextPath;
    }

    @Override
    public void destroy() {

    }
}
