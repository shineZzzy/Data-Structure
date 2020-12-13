import java.util.Scanner;

public class AGCTU {
    public static void findGC(String s,int n){
        int count=0;
        int max=0;
        int gap=n-1;
        int j=0,i=0;
        int index=0;
        for(i=0;i<s.length()-1;i++) {
            for (j = i - gap; j>=0;j=j-gap){
                if(s.charAt(i)=='G'||s.charAt(i)=='C'){
                    count++;
                }else {
                    count=0;
                }
            }
            if(count>max){
                max=count;
                index=i;
            }
        }
        System.out.println(s.substring(index-gap, index+1));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //输入序列
        String s=sc.nextLine();
        //输入要求字串长度
        int n=sc.nextInt();
        findGC(s,n);
    }
}