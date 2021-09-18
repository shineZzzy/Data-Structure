package Sloution;

/**
 * 打印直方图
 */
public class T10 {
    public static void main(String[] args) {
        String[] str={"aaaaa","b","c"};
        int[] nums={3,5,4};
        printStr(str,nums);
    }

    private static void printStr(String[] str, int[] nums) {
        int[] len=new int[str.length];
        int index=0;
        for (String s : str) {
            len[index++]=s.length();
        }
        int n=nums.length;
        int max=nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i]>max){
                max=nums[i];
            }
        }
        int[] cha=new int[n];
        for(int i=0;i<n;i++){
            cha[i]=max-nums[i];
        }

        for(int i=0;i<max;i++){
           for(int j=0;j<n;j++){
               if (cha[j]>0){
                   System.out.print(" ");
                   for(int k=0;k<len[j];k++){
                       System.out.print(" ");
                   }
                   cha[j]--;
               }else {
                   System.out.print("#");
                   for(int k=0;k<len[j];k++){
                       System.out.print(" ");
                   }
               }
           }
            System.out.println();
        }
        int x=0;
        for (int i : len) {
            x+=i;
        }
        for (int i = 0; i < x; i++) {
            System.out.print("--");

        }
        System.out.println();
        for (String s : str) {
            System.out.print(s+" ");
        }


    }
}
