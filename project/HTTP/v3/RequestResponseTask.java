package Mine.v3;

import java.io.*;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RequestResponseTask implements Runnable {

    private static final String DOC_BASE = "E:\\java-code\\Maven\\project3\\docBase";
    private final Socket socket;
    RequestResponseTask(Socket socket){
        this.socket=socket;
    }

    //定义后缀名
    private static final Map<String, String> mimeTypeMap = new HashMap<>();
    static {
        mimeTypeMap.put("txt", "text/plain");
        mimeTypeMap.put("html", "text/html");
        mimeTypeMap.put("js", "application/javascript");
        mimeTypeMap.put("jpg", "image/jpeg");
    }

    @Override
    public void run() {
        //连接已经建立成功，开始通信
        try {
            System.out.println("TCP已连接");

            //进行HTTP请求解析，解析路径
            InputStream inputStream=socket.getInputStream();
            Scanner  sc=new Scanner(inputStream,"UTF-8");
            sc.next();//第一次读取，读的是方法，暂时不用，不保存
            String path=sc.next();
            System.out.println(path);
            sc.nextLine();//读取HTTP版本信息


            //动态资源处理
            //1.分离URI\queryString
            //先假设不分离
            String requestURI = path;
            String queryString = "";
            //划分
            if (path.contains("?")) {
                int i = path.indexOf("?");
                requestURI = path.substring(0, i);
                queryString = path.substring(i + 1);
            }
            System.out.println(requestURI);

            Map<String, String> headers = new HashMap<>();
            // 通过 scanner，读取请求头
            String headerLine;
            //先读取一行，再判断是否为空
            while (sc.hasNextLine() && !(headerLine = sc.nextLine()).isEmpty()) {
                // 通过 ":" 分割
                String[] part = headerLine.split(":");
                String name = part[0].trim().toLowerCase(); // HTTP 的 header-name 大小写不敏感
                String value = part[1].trim();//trim()可以修剪空格

                headers.put(name, value);
            }


            //默认/-->index首页，特殊处理
            if (requestURI.equals("/")){
                path="/index.html";
            }
            if (requestURI.equals("/set-cookie")) {
                //种下 cookie
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);

                //重定向
                printWriter.printf("HTTP/1.0 307 Temporary Redirect\r\n");
                printWriter.printf("Set-Cookie: username=Hahaha\r\n");
                printWriter.printf("Location: profile\r\n");
                printWriter.printf("\r\n");
                printWriter.flush();

            } else if (requestURI.equals("/profile")) {
                //使用cookie，请求头解析
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);

                String username = null;
                // 从 cookie 中获取 username
                String cookie = headers.getOrDefault("cookie", "");
                System.out.println("Cookie value:" + cookie);
                for (String cookieKV : cookie.split(";")) {
                    if (cookieKV.isEmpty()) {
                        continue;
                    }
                    String[] kv = cookieKV.split("=");
                    String cookieName = kv[0];
                    String cookieValue = kv[1];
                    if (cookieName.equals("username")) {
                        username = cookieValue;
                    }
                }

                printWriter.printf("HTTP/1.0 200 OK\r\n");
                printWriter.printf("Content-Type: text/html; charset=utf-8\r\n");
                printWriter.printf("\r\n");
                if (username != null) {
                    printWriter.printf("<h1>当前用户是: %s</h1>", username);
                } else {
                    printWriter.printf("<h1>您需要先进行登录</h1>");
                }
                printWriter.flush();
            }else if (requestURI.equals("/redirect-to")) {
                //重定向
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);

                printWriter.printf("HTTP/1.0 307 Temporary Redirect\r\n");
                printWriter.printf("Location: /1.jpg\r\n");
                printWriter.printf("\r\n");
                printWriter.flush();
            }else if(requestURI.equals("/goodbye.html")){
                OutputStream outputStream = socket.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                PrintWriter printWriter = new PrintWriter(writer);


                //2.找requestURI中的target
                String target = "世界";
                for (String kv : queryString.split("&")) {
                    if (kv.isEmpty()) {
                        //处理target==null情况
                        continue;
                    }
                    String[] part = kv.split("=");
                    String key = part[0];
                    String value = part[1];
//
//                    String key = URLDecoder.decode(part[0], "UTF-8");
//                    String value = URLDecoder.decode(part[1], "UTF-8");
                    // URLEncoder.encode() 这个是进行 URL 编码
                    if (key.equals("target")) {
                        target = value;
                    }
                }



                printWriter.printf("HTTP/1.0 200 OK\r\n");
                printWriter.printf("Content-Type: text/html; charset=utf-8\r\n");
                printWriter.printf("\r\n");
                printWriter.printf("<h1> 再见，%s</h1>", target);
                printWriter.flush();
            }else {

                //待访问文件路径
                String filePath = DOC_BASE + requestURI;  // 用户请求的静态资源对应的路径
                //先判断文件是否存在，存在：读取内容，写入响应体 不存在：返回404
                File resource = new File(filePath);
                if (resource.exists()) {
                    OutputStream outputStream = socket.getOutputStream();
                    Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                    PrintWriter printWriter = new PrintWriter(writer);
                    //根据后缀名确定Content-Type
                    //先默认为ext/plain
                    String contentType = "text/plain";
                    //找后缀名(字符串处理)
                    if (requestURI.contains(".")) {

                        int i = path.lastIndexOf(".");
                        String suffix = path.substring(i + 1);//后缀名
                        //根据定义好的的后缀名，去获取对应type，没找到就用默认
                        contentType = mimeTypeMap.getOrDefault(suffix, contentType);
                    }

                    // 如果 contentType 是 "text/..."，代表是文本
                    // 我们都把字符集统一设定成 utf-8
                    if (contentType.startsWith("text/")) {
                        contentType = contentType + "; charset=utf-8";
                    }

                    //标准中规定的响应格式，否则无法正确处理
                    printWriter.printf("HTTP/1.0 200 OK\r\n");
                    printWriter.printf("Content-Type: %s\r\n", contentType);
                    printWriter.printf("\r\n");
//                printWriter.printf("<h1>%s: 你好，世界</h1>", path);
                    printWriter.flush();

                    //写body部分，body来自读取文件
                    try (InputStream resourceInputStream = new FileInputStream(resource)) {
                        byte[] buffer = new byte[1024];
                        while (true) {
                            int len = resourceInputStream.read(buffer);
                            if (len == -1) {
                                break;
                            }
                            outputStream.write(buffer, 0, len);
                        }
                        outputStream.flush();
                    }

                } else {
                    //404
                    OutputStream outputStream = socket.getOutputStream();
                    Writer writer = new OutputStreamWriter(outputStream, "UTF-8");
                    PrintWriter printWriter = new PrintWriter(writer);

                    printWriter.printf("HTTP/1.0 404 Not Found\r\n");
                    printWriter.printf("Content-Type: text/html; charset=utf-8\r\n");
                    printWriter.printf("\r\n");
                    printWriter.printf("<h1>%s: 对应的资源不存在</h1>", path);
                    printWriter.flush();

                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("TCP连接已断开！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
