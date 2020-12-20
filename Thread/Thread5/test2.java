package Thread5;

/**
 * 50个座位、由3个老师同时安排，每个老师安排100个同学
 * 作为编号为0-49，同学可以循环操作来安排？直到座位安排满
 *
 *
 * 50个数，3个线程同时启动，每个线程100次，直到count=50；
 */
public class test2 {
    private static int Z=50;
    public static void main(String[] args) {
        Class c=safe2.class;
        Thread[] t=new Thread[3];
        for(int i=0;i<3;i++){
            t[i]=new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i=0;i<100;i++){
                        synchronized (c){
                            if(Z>0){
                                Z--;
                                System.out.println(Thread.currentThread().getName()+"安排座位给"+i+"同学");
                            }
                        }
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
        for (Thread tt:t){
            tt.start();
        }

    }

}
