package EveryDay.Mar.Day7;
import java.util.*;
//IDEA可通过，OJ不能通过，若连续输入两组，会混合结果输出，不能分离

public class splitNumber {
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
        ArrayList<String > array=new ArrayList<>();
        while (sc.hasNext()){
            char[] c=new char[8];
            String res;
            int n=sc.nextInt();
            for (int i = 0; i <n; i++) {
                c=sc.next().replace("-","").toCharArray();
                res=getNumber(c);
                if (!array.contains(res)){
                    array.add(res);
                }
            }
            //按序打印
            Collections.sort(array);
            for (String s:array) {
                System.out.println(s);
            }
            System.out.println();
        }
    }

    private static String getNumber(char[] c) {
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < c.length; i++) {
            if (i==3){
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
