package learn.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class testPool1 {
    public static void main(String[] args) {
        //1.创建服务，创建线程池
        ExecutorService service= Executors.newFixedThreadPool(10);
        // 执行
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());
        service.execute(new MyThread());

        //关闭链接
        service.shutdown();



    }
}


class MyThread implements Runnable{
    @Override
    public void run() {
//        for (int i = 0; i < 10; i++) {
//            System.out.println(Thread.currentThread().getName()+i);
//        }
        System.out.println(Thread.currentThread().getName());
    }
}

