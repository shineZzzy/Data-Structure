package LeetCode.Top100;

/**
 *
 */
public class T04 {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //先合并，再二分求中值
        int[] extra=merge(nums1,nums2);
        double middle=binaryMiddle(extra);
        return middle;
    }

    private static double binaryMiddle(int[] extra) {
        double middle=0;
        int i=0;
        int j=extra.length-1;
        int mid=0;
        if (extra.length%2==0){
            mid=(i+j)/2+1;
            middle=(extra[mid]+extra[mid-1])/2.0;
        }else {
            mid=(i+j)/2;
            middle=extra[mid];
        }
//        System.out.println(mid);
        return middle;
    }

    private static int[] merge(int[] nums1, int[] nums2) {

        int n=nums1.length;
        int m=nums2.length;
        int[] res=new int[n+m];
        int resIndex=0;
        int i=0;
        int j=0;
        while (i<n && j<m){
            if (nums1[i]<=nums2[j]){
                res[resIndex]=nums1[i];
                resIndex++;
                i++;
            }else {
                res[resIndex]=nums2[j];
                resIndex++;
                j++;
            }
        }
        while (i!=n){
            res[resIndex++]=nums1[i++];
//            i++;
        }
        while (j!=m){
            res[resIndex++]=nums2[j++];
//            j++;
        }
//        return list.toArray();
        return res;
    }


    public static void main(String[] args) {
        int[] n={};
        int[] m={2,3};
        double res = findMedianSortedArrays(n, m);
        System.out.printf("%5s",res);

    }
}
