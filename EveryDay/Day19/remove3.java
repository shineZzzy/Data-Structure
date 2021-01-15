package Java;

/**
 * 双指针
 */
public class remove3 {
    public static int removeElement(int[] nums, int val) {
        int i=0;
        for (int j=0;j<nums.length;j++){
            if (nums[j]!=val){
                nums[i++]=nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] n={3,2,2,3};
        int k=3;
        System.out.println(removeElement(n, k));
    }
}
