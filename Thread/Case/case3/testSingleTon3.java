package learn.NThread.Case.case3;

public class testSingleTon3 {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(SingleTon3.getInstance().hashCode());
                }
            }).start();
        }
    }
}
