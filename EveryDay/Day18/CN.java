package Day18;

public class CN {
    public String str="6";
    public static void main(String[] args) {
        CN c=new CN();
        c.change(c.str);
        System.out.println(c.str);
    }
    public void change(String str){
        str="10";
    }
}
