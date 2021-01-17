package learn;

import java.util.ArrayList;
import java.util.List;

public class unsafe2 {

    public static void main(String[] args) {
        List<String> l=new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (l){
                        l.add(Thread.currentThread().getName());
                    }

                }
            }).start();
        }

        try {
            //延时时间为3秒，线程安全了，本身应该是不安全的。解决：延时加长
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(l.size());
    }
}
