package Sloution.金山云;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 第K个最大的数
 * 还是选了最简单的方法来做了
 */
public class Main {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int[] nums=new int[n];
        for(int i=0;i<n;i++){
            nums[i]=sc.nextInt();
        }

        int res=findMaxK(nums,k);
        System.out.println(res);
    }


    public static int findMaxK(int[] nums,int k){
        int len=nums.length;
        if(len==0 || k==0){
            return 0;
        }
        if(k>len){
            return -1;
        }
        Arrays.sort(nums);
        List<Integer> list=new ArrayList<>();
        for(int i=len-1;i>=0;i--){
            if(!list.contains(nums[i])){
                list.add(nums[i]);
            }
        }
        System.out.println(list);
        return nums[k-1];
    }
}
