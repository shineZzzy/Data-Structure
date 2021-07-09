package LeetCode1.dfs.T405_;

import java.util.ArrayList;
import java.util.List;

/**
 *回溯(评论区题解)
 */
public class T405_1 {
    public static int[] nums={1,2,4,8,1,2,4,8,16,32};
    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> res=new ArrayList<>();
        if(turnedOn>=9){
            return res;
        }
        dfs(0,0,0,turnedOn,res);
        return res;
    }

    private static void dfs(int h, int m, int index,
                            int turnedOn, List<String> res) {
        if(turnedOn==0){
            res.add(h+":"+((m<10)?"0":"")+m);
            return;
        }
        int len=nums.length;
        for (int i = index; i <len && turnedOn>0; i++) {
            //数组前四个
            if(i<4 && h+nums[i]<12){
                dfs(h+nums[i],m,i+1,turnedOn-1,res);
            }
            //数组后六个
            if(i>=4 && m+nums[i]<60){
                dfs(h,m+nums[i],i+1,turnedOn-1,res);
            }
        }
    }
    public static void main(String[] args) {
        int turnedOn=2;
        List<String> res = readBinaryWatch(turnedOn);
        System.out.println(res);
    }
}
