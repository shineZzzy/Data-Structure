package learn.NThread.Case.case1;

/**
 * 创建一个常量
 * 将构造方法设为私有
 * 用一个公开方法将对象返回
 */
public class singleTon {
    private static final singleTon instance =new singleTon();
    private singleTon(){ }
    public static singleTon getInstance(){
        return instance;
    }
}
