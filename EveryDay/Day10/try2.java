package Day10;

public class try2 {
    public static void main(String[] args) {
        StringBuffer a=new StringBuffer("A");
        StringBuffer b=new StringBuffer("B");
        operator(a,b);
        System.out.println(a+","+b);
    }
    public static void operator(StringBuffer x,StringBuffer y){
        x.append(y);//x变了
        y=x;//没传出去！
    }
}
