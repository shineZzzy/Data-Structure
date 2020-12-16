package Thread3;

/*
* 实现runnable接口
* 创建实现runnable接口的类
* 重写Thread类的run方法
* 创建Thread子类对象
* 调用start()
*/
class Method implements Runnable{
    //实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        for (int i=0;i<20;i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}
public class create4 {
    public static void main(String[] args) {
        //创建实现类的对象
        Method m=new Method();
        //将此对象作为参数传递到Thread类的构造方法中，创建Thread类对象
        Thread t1=new Thread(m);
        //调用start
        t1.start();
    }

}
