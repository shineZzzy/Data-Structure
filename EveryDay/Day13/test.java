package Day13;

public class test {
    public static void main(String[] args) {
        Thread t=new Thread(){
            public void run(){
                dianping();
            }
        };
        t.run();
        System.out.println("dazhong");
    }
    static void dianping(){
        System.out.println("dianping");
    }

}
