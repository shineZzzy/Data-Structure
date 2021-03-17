package ThreadHigh.LowThread.PC;

/**
 * 升级需求：
 * 生产者每个最多生产30次，一次生产3个，每天生产10*30*3=900
 * 消费者不再一直消费，消费上限为900
 */
public class BreadShop1 {
    private static int COUNT;
    private static int PRODUCE_NUMBER;

    //消费者
    public static class Consumer implements Runnable{
        private String name;

        public Consumer(String name) {
            this.name = name;
        }

        @Override
        public void run() {

            try {
                while (true) {
                    if (PRODUCE_NUMBER==900){
                        break;
                    }
                    synchronized (BreadShop.class) {
                        if (COUNT==0){
                            BreadShop.class.wait();
                        }else {
                            System.out.printf("消费者 %S 消费了1个面包\n",name);
                            COUNT--;
                            BreadShop.class.notifyAll();
                            Thread.sleep(500);
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
        private int num;

        public Producer(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                for (int i = 0; i < 30; i++) {
                    synchronized (BreadShop.class) {
                        if (COUNT+3>100) {
                            BreadShop.class.wait();
                        } else {
                            System.out.printf("生产者 %S 生产了3个面包\n",name);
                            COUNT+=3;
                            PRODUCE_NUMBER+=3;
                            BreadShop.class.notifyAll();
                            Thread.sleep(500);
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
            c[i]=new Thread(new BreadShop1.Consumer(String.valueOf(i)));
        }
        Thread[] p=new Thread[10];
        for (int i = 0; i < 10; i++) {
            p[i]=new Thread(new BreadShop1.Producer(String.valueOf(i)));
        }

        for (int i = 0; i < 20; i++) {
            c[i].start();
        }
        for (int i = 0; i < 10; i++) {
            p[i].start();
        }
    }

}
