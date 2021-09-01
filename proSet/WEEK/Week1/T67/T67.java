package LeetCode.剑指offer.Week1.T67;

/**
 * 把字符串转换成整数
 * 思路：逐个击破
 * 链接：https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
 */
public class T67 {
    public static int strToInt(String str) {
        int len=str.length();
        if (len<=0){
            return 0;
        }
        int index=0;
        char[] ch=str.toCharArray();
        //跳过空格
        while (index<ch.length && ch[index]==' '){
            index++;
        }
        //如果该字符串中全都是空格
        if (index==ch.length){
            return 0;
        }
        boolean isMinus=false;
        long res=0;
        //跳过”+“、”-“号
        if (ch[index]=='+'){
            index++;
        }else if (ch[index]=='-'){
            index++;
            isMinus=true;
        }

        //处理数字部分
        while (index<ch.length && Character.isDigit(ch[index])){
            res=res*10 + ch[index]-'0';
            //计算过程中判断是否越界
            if (res>Integer.MAX_VALUE){
                return isMinus ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            index++;
        }
        //如果字符串开头是符号，res*=-1 long转int
        return isMinus ? -(int)res : (int)res;
    }

    public static void main(String[] args) {
//        String str="-91283472332";
//        String str=" ";
        String str="9223372036854775808";
//        String str="2147483648";
        int res = strToInt(str);
        System.out.println(res);
    }
}
