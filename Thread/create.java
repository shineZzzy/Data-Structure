package Thread3;
class Thread1 extends Thread {
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0){
                System.out.println(MyThread.currentThread().getName()+":"+i);
            }
        }
    }
}

class Thread2 extends Thread{
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            if(i%2!=0){
                System.out.println(Thread2.currentThread().getName()+":"+i);
            }
        }
    }
}
public class create {

    public static void main(String[] args) {
        MyThread t1=new MyThread();
        Thread2 t2=new Thread2();
        t1.start();
        t2.start();
    }
}
