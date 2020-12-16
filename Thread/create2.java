package Thread3;

public class create2 {

    public static void main(String[] args) {
        //创建方式二：匿名类
        Thread t1=new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=0;i<20;i++){
                    System.out.println(Thread.currentThread().getPriority()+":"+i);
                }
            }
        });
        t1.start();
        System.out.println(Thread.currentThread().getPriority()+"hello");
    }
}
