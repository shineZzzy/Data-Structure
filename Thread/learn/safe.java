package learn;

//不安全的取钱
//有两个人去银行取钱，账户
public class safe {

    public static void main(String[] args) {
        //账户
        Account a=new Account(100,"个人账户");
        Drawing you=new Drawing(a,50," 你");
        Drawing she=new Drawing(a,100," 她");
        you.start();
        she.start();

    }
    
}
//账户

//?
class Account{
    public int money;//余额
    public String name;//账号

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}


//银行：模拟取款
class Drawing extends Thread{
    Account a;//账户
    int drawingMoney;//取了多少钱
    int nowMoney;//现在剩余

    public Drawing(Account a,int drawingMoney,String name){

        super(name);
        this.a=a;
        this.drawingMoney=drawingMoney;

    }

    //取钱
    @Override
    public void run() {
        //代码块
        //解决线程不安全问题
        //锁的对象是变化的量，需要增删查改的对象
        synchronized (a){
            if(a.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"余额不足");
                return;
            }
            //sleep可以放大问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额=余额-你取的钱
            a.money=a.money-drawingMoney;
            //剩余
            nowMoney=nowMoney+drawingMoney;

            System.out.println(a.name+"余额为："+a.money);

            //Thread.currentThread().getName()=this.getName();
            System.out.println(Thread.currentThread().getName()+"手里的钱"+nowMoney);

        }


//    @Override
//    public synchronized void run() {
        //synchronized 默认上锁的是this，所以并没有起到什么实质性的作用
        //判断是否有钱
//        if(a.money-drawingMoney<0){
//            System.out.println(Thread.currentThread().getName()+"余额不足");
//            return;
//        }
//
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        //卡内余额=余额-你取的钱
//        a.money=a.money-drawingMoney;
//        //剩余
//        nowMoney=nowMoney+drawingMoney;
//
//        System.out.println(a.name+"余额为："+a.money);
//
//        //Thread.currentThread().getName()=this.getName();
//        System.out.println(Thread.currentThread().getName()+"手里的钱"+nowMoney);

    }
}