package Thread5;

public class synchronizedTest {
    private static int COUNT;
//    public static void increment(){
//        synchronized (synchronizedTest.class) {
//            COUNT++;
//        }
//    }
    //对当前类对象进行加锁，线程间同步互斥
    public synchronized static void increment(){
        COUNT++;
    }


    public static void main(String[] args) throws InterruptedException {
        Class c=safe2.class;
        Thread[] t=new Thread[20];
        for (int i=0;i<19;i++) {
            t[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {

                        synchronized (c) {
//                            increment();
                            COUNT++;
                        }
                    }
                }
            });
        }
        for (int i=0;i<1;i++){
            t[19+i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increment();
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
