package learn.NThread.Case.case2;

/**
 * 检验singleTon2
 * 多线程运行下，结果不一致，创建了多个对象
 * 解决：加互斥锁
 */

public class testSingleTon {
    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(SingleTon.getInstance().hashCode());
                }
            }).start();
        }
    }
}
