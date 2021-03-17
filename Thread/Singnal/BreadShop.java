package ThreadHigh.LowThread.PC;

public class BreadShop {
    private static int COUNT;
    //消费者
    public static class Consumer implements Runnable{
        private String name;

        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                while (true){
                    synchronized (BreadShop.class){
                        if (COUNT==0){
                            BreadShop.class.wait();
                        }else {
                            System.out.printf("%s 消费了1个面包\n",name);
                            COUNT--;
                            BreadShop.class.notifyAll();
                            Thread.sleep(1000);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //生产者
    public static class Producer implements Runnable{
        private String name;

        public Producer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    synchronized (BreadShop.class) {
                        if (COUNT+3>100){
                            BreadShop.class.wait();
                        }else {
                            System.out.printf("生产者 %S 生产了3个面包\n",name);
                            COUNT+=3;
                            BreadShop.class.notifyAll();
                            Thread.sleep(1000);
                        }
                    }
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Thread[] c=new Thread[20];
        for (int i = 0; i < 20; i++) {
            c[i]=new Thread(new Consumer(String.valueOf(i)));
        }
        Thread[] p=new Thread[10];
        for (int i = 0; i < 10; i++) {
            p[i]=new Thread(new Producer(String.valueOf(i)));
        }

        for (int i = 0; i < 20; i++) {
            c[i].start();
        }
        for (int i = 0; i < 10; i++) {
            p[i].start();
        }
    }
}
