package EveryDay.Mar.Day7;
import java.util.*;

/**
 * 电话号码
 * 描述：一个电话的九宫格，如你所见一个数字对应一些字母，因此在国外企业喜欢把电话号码设计成与自己公司名字相对应。例如公司的Help Desk号码是4357，因为4对应H、3对应E、5对应L、7对应P，因此4357就是HELP。同理，TUT-GLOP就代表888-4567、310-GINO代表310-4466。
 *      NowCoder刚进入外企，并不习惯这样的命名方式，现在给你一串电话号码列表，请你帮他转换成数字形式的号码，并去除重复的部分
 * 关键：1.连字符'-'的位置 2.结果不重复 3.有序打印输出
 * 链接：https://www.nowcoder.com/questionTerminal/ceb89f19187b4de3997d9cdef2d551e8
 */

public class splitN2 {
    public static List<Character> l2= Arrays.asList('A','B','C');
    public static List<Character> l3= Arrays.asList('D','E','F');
    public static List<Character> l4= Arrays.asList('G','H','I');
    public static List<Character> l5= Arrays.asList('J','K','L');
    public static List<Character> l6= Arrays.asList('M','N','O');
    public static List<Character> l7= Arrays.asList('P','Q','R','S');
    public static List<Character> l8= Arrays.asList('T','V','U');
    public static List<Character> l9= Arrays.asList('W','X','Y','Z');

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            String[] inp = new String[n];
            for (int i = 0; i < n; i++) {
                //连字符处理
                inp[i]=sc.next().replace("-","");
            }
            spiltStr(inp);
            System.out.println();
        }
    }

    private static void spiltStr(String[] inp) {
        char[] c=new char[8];
        String s;
        ArrayList<String > a =new ArrayList<>();
        for (int i = 0; i < inp.length; i++) {
            //对每一行的输入，分离处理
            c=inp[i].toCharArray();
            s=getNumber(c);
            //去重
            if (!a.contains(s)){
                a.add(s);
            }
        }
        //排序
        Collections.sort(a);
        for (String str:a) {
            System.out.println(str);
        }
    }

    private static String getNumber(char[] c) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (i==3){
                //连字符位置处理
                sb.append('-');
            }
            if (l2.contains(c[i])){
                sb.append("2");
            }else if (l3.contains(c[i])){
                sb.append("3");
            }else if (l4.contains(c[i])){
                sb.append("4");
            }else if (l5.contains(c[i])){
                sb.append("5");
            }else if (l6.contains(c[i])){
                sb.append("6");
            }else if (l7.contains(c[i])){
                sb.append("7");
            }else if (l8.contains(c[i])){
                sb.append("8");
            }else if (l9.contains(c[i])){
                sb.append("9");
            }else {
                sb.append(c[i]);
            }
        }
        return sb.toString();
    }

}
