package K;

/**
 * 将句子重新排序
 * 题意：给你一个 打乱顺序 的句子 s ，它包含的单词不超过 9 个，请你重新构造并得到原本顺序的句子
 * 思路：插排(实际上复杂了，没有利用好数字的作用)
 * 巧妙解法：直接把单词尾部的数字当下标用，下标-1存入数组对应位置(前提是数字连续，很明显题意是连续的)
 */
public class T1859 {
    public static String sortSentence0(String s) {
        String[] str=s.split(" ");
        int n=0;
        for (int i = 0; i < str.length-1; i++) {
            n=Integer.parseInt(String.valueOf(str[i+1].charAt(str[i+1].length()-1)));

            String temp=str[i+1];
            int j=0;
            for (j=i;j>=0;j--){
                if (n<Integer.parseInt(String.valueOf(str[j].charAt(str[j].length()-1)))){
                    str[j+1]=str[j];
                }else {
                    break;
                }
            }
            str[j+1]=temp;
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (i!=str.length-1){
                sb.append(str[i],0,str[i].length()-1).append(" ");
            }else {
                sb.append(str[i], 0, str[i].length() - 1);
            }
        }
        return sb.toString();
    }
    //插排的思路
    public static String sortSentence1(String s) {
        String[] str=s.split(" ");
        int n=0;
        for (int i = 0; i < str.length-1; i++) {
            n=Integer.parseInt(String.valueOf(str[i+1].charAt(str[i+1].length()-1)));

            String temp=str[i+1];
            int j=0;
            for (j=i;j>=0;j--){
                if (n<Integer.parseInt(String.valueOf(str[j].charAt(str[j].length()-1)))){
                    str[j+1]=str[j];
                }else {
                    break;
                }
            }
            str[j+1]=temp;
        }
        for (int i = 0; i < str.length; i++) {
            StringBuilder sb=new StringBuilder();
            sb.append(str[i],0,str[i].length()-1);
            str[i]=sb.toString();
        }
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < str.length; i++) {
            if (i!=str.length-1){
                sb.append(str[i]).append(" ");
            }else {
                sb.append(str[i]);
            }
        }
        return sb.toString();
    }
    //这个解法米奇妙妙屋啊！
    //直接将数字作为下标，由于最大不会超过9，所以减1后当作下标将元素存入数组，不用刻意排序！！！
    public static String sortSentence(String s){
        String[] strs = s.split(" ");
        String[] res = new String[strs.length];

        for (String str : strs) {
            // 把数字字符('0'~'9')当做下标
            int num = str.charAt(str.length() - 1) - '0' - 1;
            // 保存单词
            res[num] = str.substring(0, str.length() - 1);
        }
        return String.join(" ", res);
    }

    public static void main(String[] args) {
        String s="is2 sentence4 This1 a3";
        String res = sortSentence(s);
        System.out.println(res);
    }
}
