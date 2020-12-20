package Thread5;

public class safe2 {
    /**
     * count=0;
     * 同时启动20个线程，每个循环1000次，每次count++
     * 等20个都执行完后，main线程打印count
     * synchronized
     * 线程安全
     * @param args
     */
    private static int COUNT=0;
    public static void main(String[] args) throws InterruptedException {
        //当前类对象
        Class c=safe2.class;
        //尽量同时启动，不让new Thread耗时影响
        Thread[] t=new Thread[20];
        for (int i=0;i<20;i++) {
            t[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        //对当前类加锁，以实现安全
                        synchronized (c) {
                            COUNT++;
                        }
                    }
                }
            });
        }
            //20次启动
            for (Thread tt:t){
                tt.start();
            }
            //等待t线程全部执行完
            for (Thread tt:t){
                tt.join();
            }
            System.out.println(COUNT);
    }
}
