package learn.NThread.Case.case3;

/**
 * 单例模式3：静态内部类方法
 */
public class SingleTon3 {
    private SingleTon3(){}
    //私有方法，不使用就不会被调用
    private static class Holder{
        //通过new对象方式创建，线程安全，原子操作
        static SingleTon3 instance=new SingleTon3();
    }
    public static SingleTon3 getInstance(){
        //使用时，才调用变量去创建
        return Holder.instance;
    }
}
