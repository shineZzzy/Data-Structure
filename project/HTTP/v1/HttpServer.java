package Mine.v1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//使用多线程完成！
public class HttpServer {
    public static void main(String[] args) throws IOException {

        //1.创建监听
        ServerSocket serverSocket=new ServerSocket(8080);
        while (true) {
            //2.建立连接
            Socket socket=serverSocket.accept();
            Runnable runnable=new RequestResponseTask(socket);
            new Thread(runnable).start();
        }
    }
    //线程池
    public static void main2(String[] args) throws IOException {
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        //1.创建监听
        ServerSocket serverSocket=new ServerSocket(8080);
        while (true){
            Socket socket=serverSocket.accept();
            Runnable runnable=new RequestResponseTask(socket);
            executorService.execute(runnable);
        }
    }
}
