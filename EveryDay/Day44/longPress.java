package Test.Day44;

import java.util.Scanner;

/**
 * 长按键入
 *  链接：https://leetcode-cn.com/problems/long-pressed-name/solution/shuang-zhi-zhen-zhi-xing-shi-jian-0ms-by-kingangel/
 * 成立条件
 * 1.未发生变化
 * 2.某一个字母双击
 * 思路：
 * 双指针，判断当前指针位置元素是否相同，相同，同步移至下一个
 * 不同，就看type的指针当前位置与前一个元素是否相同，相同，后移，不同则必然不符合条件
 */
public class longPress {

    public static boolean isLongPressedName(String name, String typed) {
        //1.判断是否为空
        if (name.length()==0 || typed.length()==0){
            return false;
        }
        int i=0,j=0;
        while (i<name.length() || j<typed.length()){
            if (i<name.length() && j<typed.length()   && (name.charAt(i)==typed.charAt(j))){
                i++;
                j++;
            }else {
                if (j>0 && j<typed.length() && typed.charAt(j)==typed.charAt(j-1)){
                    j++;
                }else {
                    return false;
                }
            }
        }
        return i==name.length() && j==typed.length();

    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            String s1=sc.nextLine();
            String s2=sc.nextLine();
            boolean res=isLongPressedName(s1,s2);
            System.out.println(res);
        }
    }
}
