package SuanFa.Tanxin;

import java.util.ArrayList;
import java.util.List;

/**
 * 柠檬水找零
 * TIP:管理5和10元的个数即可
 * 当收款>5时，优先使用10元找零，不够了再找5
 * 链接：https://leetcode-cn.com/problems/lemonade-change/
 */
public class T860 {
    public static boolean lemonadeChange0(int[] bills) {
        int len=bills.length;
        int five=0;
        int ten=0;
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (bills[i]==5){
                five++;
            }else if (bills[i]==10){
                if (five<1 ){
                    return false;
                }
                five--;
                ten++;
            }else {
                if (five>0 && ten>0){
                    ten--;
                    five--;
                }else if (five==3){
                    five-=3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums={5,5,10,10,20};
        boolean res = lemonadeChange(nums);
        System.out.println(res);
    }

    public static boolean lemonadeChange(int[] bills) {
        int len=bills.length;
        int five=0,ten=0;
        for (int i = 0; i < len; i++) {
            if (bills[i]==5){
                five++;
            }else if (bills[i]==10){
                if (five<0){
                    return false;
                }
                five--;
                ten++;
            }else {
                int out=15;
                if (ten>0){
                    out-=10;
                    ten--;
                }
                while (out>0 && five>0){
                    out-=5;
                    five--;
                }

                if (out>0){
                    return false;
                }
            }
        }
        return true;
    }

}
