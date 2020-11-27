package Day3;

import java.util.Scanner;

/**
 * 输出字符串中最长的数字串
 * 1.遍历字符串，区分数字与字母
 * 2.count记录，遇到字母或其他置为0，数字+1；
 * 3.用max保存长度，count与之比较，找最长串；
 * 4.循环记录数字串最后一个元素位置
 * 5.(last-max+1,last+1)取出数字串
 */
public class finder {
    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);
//        System.out.println("请输入字符串：");
        String s=scan.nextLine();
        char[] a = s.toCharArray();
        int fast = 0;
        int slow =0;
//        //记录数子串的长度
//        List<Integer> list=new ArrayList<>();
        //记录数子串的长度
        int count=0;
        int max=0;
        for(int i=0;i<a.length;i++){
//            fast=slow;
            if (a[i] >= '0' && a[i] <= '9') {
//                slow = i;
//                 fast++;
                count++;
                if (max < count) {
                    max = count;
                    slow = i;
                }
            }else {
                count=0;
            }

        }
//        System.out.println(max);
        System.out.println(s.substring(slow-max+1,slow+1));
    }
}
