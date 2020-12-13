import java.util.Scanner;

public class test2 {
    public static void findGC(String s,int n){
        int count=0;
        int max=0;
        int gap=n-1;
        int index=0;
        for(int i=gap;i<s.length()-n;i++) {
            for (int j = i; j<i+n;j++){
                if(s.charAt(i)=='G'||s.charAt(i)=='C'){
                    count++;
                }
            }
            if(count > max){
                max=count;
                index=i;
            }
        }
        System.out.println(s.substring(index-gap, index+1));
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            int n = sc.nextInt();
            findGC(s, n);
        }
    }
}
