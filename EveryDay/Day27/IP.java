package Test.Day27;
import java.util.Scanner;

//IP地址与整数互相转换
public class IP {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            String str=sc.nextLine();
            String res="";
            if(str.contains(".")){
                res=trans(str);
            }else {
                res=IntStr(str);
            }
            System.out.println(res);
        }
    }

    private static String trans(String str) {
        int n=4;
        long res=0;
        long m=0;
        String[] s=str.split("\\.");
        for (int i = 0; i <n; i++) {
            m = res * 256;
            res = m +Integer.parseInt(s[i]);
        }
        return ""+res;

    }

    private static String IntStr(String str) {
        int n=4;
        String res = "";
        long ip=Long.parseLong(str);
        long m=0;
        for (int i = 0; i < n ; i++) {
            m = ip %256;
            res = m + "."+res;
            ip /=256;
        }
        return res.substring(0, res.length()-1);
    }
}
//10.0.3.193
//167969729

