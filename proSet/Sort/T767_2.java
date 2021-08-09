package Sort.T767_;

/**
 * 重构字符串
 * 技术排序、奇数偶数位插空排列
 * 链接：https://leetcode-cn.com/problems/reorganize-string/
 */
public class T767{
    public static String reorganizeString(String s) {
        int len= s.length();
        char[] c= s.toCharArray();
        int[] chCnt=new int[26];
        for (int i = 0; i < c.length; i++) {
            chCnt[c[i]-'a']++;
        }

        int cnt=0,max=0,maxIndex=0;
        int maxCnt=0;
        if (len%2==0){
            maxCnt=len/2;
        }else {
            maxCnt=(len+1)/2;
        }
        //找出出现次数最多的那个值
        for (int i = 0; i < chCnt.length; i++) {
            if (chCnt[i]>max){
                max=chCnt[i];
                maxIndex=i;

                if(max>maxCnt){
                    return "";
                }
            }
        }

        //进行奇偶位插入！
        char[] res=new char[len];
        int index=0;
        while (chCnt[maxIndex]>0){
            //转为字符
            res[index]=(char) (maxIndex + 'a');
            index+=2;
            //每次填入一个，就将当前count-1
            chCnt[maxIndex]--;
        }
        //对于剩余元素在空位子插入
        for (int i = 0; i < chCnt.length; i++) {
            while (chCnt[i]>0){
                //如果走到末尾了，就重置下标
                if(index>=res.length){
                    index=1;
                }
                res[index]=(char)(i+'a');
                index+=2;
                chCnt[i]--;
            }
        }

        return new String(res);
    }
    public static void main(String[] args) {
        String s="bfrbs";
        String res = reorganizeString(s);
        System.out.println(res);
    }
}
