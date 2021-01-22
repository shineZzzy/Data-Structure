package Test.T0121;

import java.util.Scanner;

public class isCont {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            String s1 = sc.nextLine();
            contain(s,s1);
        }
    }
    public static void contain(String s,String s1){
//        List<Character> l=new ArrayList<>();
        int count=0;
        boolean flag=false;
        int[] n=new int[s1.length()+1];
        for (int i=0;i<s.length();i++){
            n[s.charAt(i)]++;
        }
        for (int j=0;j<s1.length();j++){
            int index=s1.charAt(j);
            if(n[index]!=0){
                n[index]--;
            }else {
                flag=true;
                count++;
            }
        }
        if(flag){
            System.out.println("No "+count);
        }else {
            System.out.println("Yes "+(s.length()-count));
        }
    }
}
