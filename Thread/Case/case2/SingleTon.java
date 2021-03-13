package learn.NThread.Case.case2;

/**
 * 懒汉式单例
 * 创建一个对象，赋值为null
 * 构造方法私有，类外部无法创建对象
 * 用公开方法返回该对象
 */
public class SingleTon {
    private static SingleTon instance=null;
    private SingleTon(){}

    //多线程不安全
    public static SingleTon getInstance0(){
        if (instance==null){
            //用到了，开始实例化
            instance=new SingleTon();
        }
        return instance;
    }

    //解决方法1：加互斥锁，但效率不高，
    //每个线程来都要判断锁，抢不到就只能等着，造成资源浪费

    //同步方法；使多线程安全
    public static synchronized SingleTon getInstance1(){
        if (instance==null){
            //用到了，开始实例化
            instance=new SingleTon();
        }
        return instance;
    }

    //同步代码块
    public static SingleTon getInstance2(){
        //此处不能直接使用instance，还没初始化为空
        //类对象唯一，可锁
        synchronized (SingleTon.class) {
            if (instance==null){
                //用到了，开始实例化
                instance=new SingleTon();
            }
        }
        return instance;
    }

    //优化思路：单例模式只需一个对象，其他线程来可以不用判断锁，
    //         双重判断符合条件直接返回即可。

    public static SingleTon getInstance(){
        if (instance==null) {
            synchronized (SingleTon.class) {
                if (instance == null) {
                    //用到了，开始实例化
                    instance = new SingleTon();
                }
            }
        }
        //没必要每个线程都去竞争锁，对象只有一个，只要一个线程实例化了直接返回就行。
        return instance;
    }
}
