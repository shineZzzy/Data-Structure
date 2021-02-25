package Test.Day42;

public class BinSum {
    public static String addBinary(String a, String b) {
        //直接调用自带函数
        //先将 a 和 b 转化成十进制数，求和后再转化为二进制数
       String s=Integer.toBinaryString(Integer.parseInt(a,2)+Integer.parseInt(b,2));
       return s;
    }

    //方法2：先遍历字符串，将位置补全，再进行求和(其实这里可以用list）
    public static String addBinary1(String a, String b) {
        //1.将长度较短的一个，前面补0
        while (a.length()>b.length()){
            b="0" + b;
        }
        while (a.length()<b.length()){
            a="0" + a;
        }
        //用来存放计算结果
        int[] n=new int[a.length()];
        int sum=0;
        int carry=0;//进位
        //遍历字符串求和，此时两条字符串为等长度，所以对应位求和
        for (int i = a.length()-1; i >=0 ; i--) {
            //加上进位
            sum=Integer.parseInt(String.valueOf(a.charAt(i)))+Integer.parseInt(String.valueOf(b.charAt(i)))+carry;
            //满2进1，设置进位
            if (sum >= 2) {
                n[i]=sum-2;
                carry=1;
            }else {
                n[i]=sum;
                carry=0;
            }
        }
        //将数组转为字符串，如果最终进位为一，需要在头部加一
        StringBuilder res= new StringBuilder();
        for (int i = 0; i <n.length ; i++) {
            res.append(n[i]);
        }
        if (carry==1){
            res.insert(0, "1");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String a="1010";
        String b="1011";
        String res=addBinary1(a,b);
        System.out.println(res);
    }
}
