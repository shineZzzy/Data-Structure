package LeetCode1.dfs.T93_;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class T93 {
    public static List<String> restoreIpAddresses(String s) {
        int len=s.length();
        List<String> res=new ArrayList<>();
        if (len<4 || len>12){
            return res;
        }

        Deque<String> path=new ArrayDeque<>();
        dfs(s,len,0,path,res);
        return res;
    }

    private static void dfs(String s, int len, int begin,
                             Deque<String> path,
                            List<String> res) {

        if (path.size()>4  || (path.size()>=4 && begin!=len)){
            return;
        }
        //4位组成1段IP
        if (path.size()==4){
            res.add(String.join(".",path));
            return;
        }
        for (int i = begin; i < len; i++) {

            String inner=s.substring(begin,i+1);
            //如果截取的字符出长度超过1位，且为前导零 或者 其长度超过了3，则剪枝
            if ((inner.length()>1 && inner.startsWith("0")) || inner.length()>3){
                continue;
            }
            //将字符串转化为数值
            //如果小于0或者大于255都无法构成IP段，剪枝
            int num=Integer.parseInt(inner);
            if (num<0 || num>255){
                continue;
            }

            path.addLast(inner);
            dfs(s,len,i+1,path,res);
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        String s="25525511135";
        List<String> res = restoreIpAddresses(s);
        System.out.println(res);
    }
}
