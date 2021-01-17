package learn;
//线程不安全，有负数
public class unsafe {
    public static void main(String[] args) {
        BuyTicket bt=new BuyTicket();



        new Thread(bt,"排队...").start();
        new Thread(bt,"牛啊！").start();
        new Thread(bt,"糟糕！").start();



    }
}

class BuyTicket implements Runnable{
    private int tick=10;
    boolean flag=true;

    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    //synchronized 同步方法，锁的是this
    private synchronized void buy() throws InterruptedException {
        if(tick<0){
            flag=false;
            return;
        }

        //本身应该是不安全的，现代设备原因不加延时看不出来。解决：增加延时
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        Thread.sleep(1000);
        //买票
        System.out.println(Thread.currentThread().getName()+"get "+tick--);
    }
}
