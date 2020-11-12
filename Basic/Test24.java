package 实验报告;

import java.util.Scanner;

//统计字符个数
public class Test24 {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String str=scan.nextLine();
        char[] chars= str.toCharArray();
        int countA=0;
        int countB=0;

        //        for (int i=0;i<c.length;i++){
//            if(i =='A'){
//                countA++;
//            }else {
//                countB++;
//            }
//        }


        for(char c:chars){
            if(c =='A'){
                countA++;
            }else {
                countB++;
            }
        }
        if(countA>countB){
            System.out.println('A');
        }else if(countA == countB) {
            System.out.println('E');
        }else {
            System.out.println('B');
        }
    }
}



