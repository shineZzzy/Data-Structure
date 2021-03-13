package learn.NThread.Case.case1;

/**
 * 用多线程检验singleTon，看拿到的对象是否是同一个
 */
public class testSingleTon {
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(singleTon.getInstance().hashCode());
                }
            }).start();
        }
    }
}
