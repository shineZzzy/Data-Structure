package LeetCode.便利蜂.大华.T2;

import java.util.HashMap;
import java.util.Map;

/**
 * 大华 20210902测开笔试题2
 * 题目：解码
 * 描述：密钥“ABCDabcd”按固定顺序排列，
 * 加密：如p1: p的10进制是112，对应2进制是 1110000 补八位：01110000 即 DaA
 *           1的十进制是49，对应二进制是11000100 补八位：011000100 即 DAa
 *      加密结果：DaADAa
 * 解码：按照逆序解码
 */
public class Main {
    public static Map<Character,Integer> map=new HashMap<>();
    static {
        map.put('A',0);
        map.put('B',1);
        map.put('C',2);
        map.put('D',3);
        map.put('a',4);
        map.put('b',5);
        map.put('c',6);
        map.put('d',7);
    }
    public static void main(String[] args) {
        String s="DaADAa";

        String res=reSet(s);
        System.out.println(res);
    }

    private static String reSet(String s) {
        int len=s.length();
        char[] ch=s.toCharArray();
        StringBuilder str=new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (map.containsKey(ch[i])){
                //获取当前字符在密钥中的固定位置
                int index=map.get(ch[i]);
                StringBuilder bin = new StringBuilder(Integer.toBinaryString(index));
                //3个为一组，不足位，0为补
                while (bin.length()<3){
                    bin.insert(0, '0');
                }
               str.append(bin);
            }
        }
        StringBuilder res=new StringBuilder();
        int n=str.length();
        int index=0;
        while (index<n){
            if (index+8<n){
                //获取下标对应的2进制序列
                String s1=str.substring(index,index+8);
                index+=8;
                //转为10进制
                int val=toDec(Integer.parseInt(s1));
                //获取10进制对应的ASCII码字符
                res.append((char)val);
            }else {
                break;
            }
        }
        return res.toString();
    }

    //转为10进制
    public  static  Integer toDec(int bi){
        String binStr = bi+"";
        Integer sum = 0;
        int len = binStr.length();
        for (int i=1;i<=len;i++){
            //第i位 的数字为：
            int dt = Integer.parseInt(binStr.substring(i-1,i));
            sum+=(int)Math.pow(2,len-i)*dt;
        }
        return  sum;
    }

}
