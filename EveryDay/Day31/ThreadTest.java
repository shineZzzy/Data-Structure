package Test.T;

class Test {
    private int data;
    int result = 0;
    public void m(){
        result += 2;
        data += 2;
        System.out.print(result + " " + data);
    }
}
class ThreadExample extends Thread {
    private Test mv;
    public ThreadExample(Test mv) {
        this.mv = mv;
    }
    public void run() {
        synchronized(mv) {
            mv.m();
        }
    }
}
class ThreadTest {
    public static void main2(String args[]){
        Test mv = new Test();
        Thread t1 = new ThreadExample(mv);
        Thread t2 = new ThreadExample(mv);
        Thread t3 = new ThreadExample(mv);
        t1.start();
        t2.start();
        t3.start();
    }


    public static void main(String args[])throws InterruptedException{
        Thread t=new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.print("2");
            }
        });
        t.start();
        t.join();
        System.out.print("1");
    }

    void waitForSignal() throws InterruptedException {
        Object obj = new Object();
        synchronized(Thread.currentThread()){
            obj.wait();
            obj.notify();
        }
    }

}
