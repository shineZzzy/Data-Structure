package Day01;

import java.util.Scanner;

/**
 * 在A串中插入B串，统计可以构成回文串的个数
 * 插入：StringBuffer.insert()
 * 回文：判断是否为回文
 * 在A中插入B，判断是否构成回文
 * 是，count++
 */
public class isHuiWen {
    //判断是否为回文结构
    public static boolean isHuiWen(String str){
        //双指针，各从前后走
        int i=0;
        int j=str.length()-1;
        while (i<j) {
            if (str.charAt(i) != str.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String A=sc.nextLine();
            String B=sc.nextLine();
            int count=0;
            for (int i=0;i<=A.length();i++) {
                //用StringBuffer的通过率不高，可能和安全性有关吧
                StringBuilder C=new StringBuilder(A);
                C.insert(i, B);
                //方法1：单独写判断是否回文的方法
                if(isHuiWen(C.toString())){
                    count++;
                }
                //方法2：直接逆转字符串用equals判断是否相同
//                if(C.toString().equals(C.reverse().toString())){
//                    count++;
//                }
            }
            System.out.println(count);
        }
    }
}
