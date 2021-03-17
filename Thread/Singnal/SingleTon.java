package ThreadHigh.LowThread.PC;

public class SingleTon {
    private static volatile SingleTon instance=null;
    private SingleTon(){}

    public static SingleTon getInstance(){
        if (instance==null){
            synchronized (SingleTon.class) {
                if (instance==null) {
                    instance=new SingleTon();
                }
            }
        }
        return instance;
    }
}
