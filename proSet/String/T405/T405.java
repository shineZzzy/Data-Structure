package LeetCode1.dfs.T405_;

import java.util.ArrayList;
import java.util.List;

/**
 * 二进制手表
 * 题意：整个题有12*60种组合，统计这些组合中“小时+分钟”的二进制中1个的个数，找出所有与给定值相符的组合
 * 链接：https://leetcode-cn.com/problems/binary-watch/
 */
public class T405 {
    //枚举所有可能性与给定值进行判断
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> res=new ArrayList<>();
        if(turnedOn>=9){
            return res;
        }
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 60; j++) {
                //如果小时和分钟的数的二进制中1个个数之和==turnedOn，则符合条件
                if(Integer.bitCount(i)+Integer.bitCount(j)==turnedOn){
                    String s=i+":"+((j<10)?"0":"")+j;
                    res.add(s);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int turnedOn=1;
        List<String> res = readBinaryWatch(turnedOn);
        System.out.println(res);
    }
}
