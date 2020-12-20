package Thread5;

public class test3 {
    private static int COUNT=50;

    public static class Task implements Runnable{
        private int num;
        public Task(int num){
            this.num=num;
        }
        @Override
        public void run() {
            for (int i=0;i<100;i++){
                synchronized (this) {
                    if (COUNT>0 && num>0){
                        COUNT--;
                        num--;
                        System.out.printf("%s,%s\n",Thread.currentThread().getName(),COUNT);
                    }
                }
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public static void main(String[] args) {
//        Thread[] t=new Thread[3];
//        Task t=new Task();
//        for (int i=0;i<3;i++){
//            new Thread(t).start();
//        }
        new Thread(new Task(10)).start();
        new Thread(new Task(20)).start();
        new Thread(new Task(50)).start();
    }
}
