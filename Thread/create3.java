package Thread3;
class MyThread extends Thread{
//    private int trick=100;//变量，会默认每个线程有一套该变量都是100
    private static int trick=100;//设为静态，该变量就仅此一份
//结果中还是出现了多个100，这属于线程不安全问题,可以用volatile关键字处理

    @Override
    public void run() {
        while (true) {
            if (trick > 0) {
                System.out.println(getName()+"正在售票中"+trick);
                trick--;
            } else {
                break;
            }
        }
    }
}
public class create3 {
    public static void main(String[] args) {
        MyThread t1=new MyThread();
        MyThread t2=new MyThread();
        t1.start();
        t2.start();
    }
}
