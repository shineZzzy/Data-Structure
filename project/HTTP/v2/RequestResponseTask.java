package Mine.v2;

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

            //默认/-->index首页，特殊处理
            if (path.equals("/")){
                path="/index.html";
            }

            //待访问文件路径
            String filePath = DOC_BASE + path;  // 用户请求的静态资源对应的路径
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
                if (path.contains(".")) {

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

            }else {
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
