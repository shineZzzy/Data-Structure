package Day1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;


//木棒拼图

public class nShape1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //操作数
        int n=sc.nextInt();
        int sum=0;
        //增删用链表特性 O(1)
        List<Integer> list=new ArrayList<>();
        for (int i = 0; i <n; i++) {
            int target=sc.nextInt();
            int length=sc.nextInt();
            if (target==1){
                //1，插入，求和
                list.add(length);
                sum+=length;
            }else if (target==2){
                //2.删除，剪掉长度
                if(list.contains(length)){
                    int index=list.indexOf(length);
                    list.remove(index);
                    sum-=length;
                }
            }
            Collections.sort(list);
            int max=list.get(list.size()-1);
            //如果其余边之和大于最长边，则可以构成简单多边形
            if (sum-max>max){
                System.out.println("Yes");
            }else {
                System.out.println("No");
            }
        }
    }
}
