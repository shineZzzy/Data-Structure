package Test.Day42;

public class BinSum {
    public static String addBinary(String a, String b) {
        //直接调用自带函数
        //先将 a 和 b 转化成十进制数，求和后再转化为二进制数
       String s=Integer.toBinaryString(Integer.parseInt(a,2)+Integer.parseInt(b,2));
       return s;
    }

    public static String addBinary1(String a, String b) {
        
    }

    public static void main(String[] args) {
        String a="11";
        String b="1";
        String res=addBinary(a,b);
        System.out.println(res);
    }
}
