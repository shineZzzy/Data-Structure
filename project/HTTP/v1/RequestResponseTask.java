package Mine.v1;

import java.io.*;
import java.net.Socket;

public class RequestResponseTask implements Runnable {

    private final Socket socket;
    RequestResponseTask(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        //连接已经建立成功，开始通信
        try {
            System.out.println("TCP已连接");


            //通信：响应信息
            OutputStream outputStream=socket.getOutputStream();
            Writer writer=new OutputStreamWriter(outputStream,"UTF-8");
            PrintWriter printWriter=new PrintWriter(writer);
            //响应头
            printWriter.printf("HTTP/1.0 200 OK\r\n");
            printWriter.printf("Content-Type:text/html\r\n");
            //响应内容
            printWriter.printf("\r\n");
            printWriter.printf("<h1>今天的代码独立完成了吗？</h1>");
            //刷新
            printWriter.flush();
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
