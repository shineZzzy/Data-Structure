package learn;

public class Demo1 {
    public static void main(String[] args) {
        God gd=new God();
        You y=new You();

        Thread t=new Thread(gd);
        t.setDaemon(true);
        t.start();
        new Thread(y).start();
    }

}
class God implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println("========上帝保佑你！=======");
        }
    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i=0;i<36500;i++){
            System.out.println("happy everyday");
        }
        System.out.println("========goodbye world!");

    }
}