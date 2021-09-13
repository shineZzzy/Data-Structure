package 笔试.远景.T1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 删除链表中的指定节点
 *
 * 给定n和 k
 * 链表中存储序号为1~n的节点，删除序号为K的节点，已经K的整数倍的节点
 * 思路：没有创建节点，直接利用链表存储序号，将k和k的整数倍的节点，删除
 *
 */
public class deleteNode {
    public static void main(String[] args) {
        Scanner sc=new Scanner( System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        List<Integer> list=new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(i);
        }
        //正序删除，会导致异常
        for(int i=list.size()-1;i>=0;i--){
            if (list.get(i)==k || list.get(i)%k==0){
                list.remove(list.get(i));
            }
        }


        int index=0;
        for (Integer i : list) {
            if (index==list.size()-1){
                System.out.print(i);
            }else {
                System.out.print(i+" ");
            }
        }

    }
}
