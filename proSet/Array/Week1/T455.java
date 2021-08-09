package SuanFa.Tanxin;
import java.util.Arrays;

/**
 * 分发饼干
 * 思路：排序+双指针(贪心)
 * 贪心：按孩子的胃口值从小到大依次满足每个孩子，
 * 且对于每个孩子，应该选择： 可以满足这个孩子的胃口且尺寸最小 的饼干
 * 链接:https://leetcode-cn.com/problems/assign-cookies/
 */

public class T455 {
    public static int findContentChildren(int[] g, int[] s) {
        int lg=g.length;
        int ls=s.length;
        int i=0;
        int j=0;
        Arrays.sort(g);
        Arrays.sort(s);
        int cnt=0;
        while (i<lg  && j<ls){

//            if (g[i]<=s[j]){
//                cnt++;
//                i++;
//                j++;
//            }else {
//                j++;
//            }

            //优化
            //既已排序，则将s[j]<g[i]的部分都跳过去，找符合条件的部分
            while (j<ls && g[i]>s[j]){
                j++;
            }
            if (j<ls){
                cnt++;
                i++;
                j++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] g={1,2,3};
        int[] s={1,1,2};
        int res = findContentChildren(g, s);
        System.out.println(res);
    }
}
