package EveryDay.offer.Sort;

import java.util.Arrays;


public class SortArr2 {
    public static int[] MySort (int[] arr) {
        // write code here
        sort(arr,0,arr.length-1);
        return arr;
    }
    public static void sort(int[] arr,int low,int high){


        int size=high-low+1;
        if(size<=1){
            return;
        }
        int key=quickSort(arr,low,high);
        quickSort(arr,low,key-1);
        quickSort(arr,key,high);
    }
    public static int quickSort(int[] arr,int low,int high) {
        int left=low;
        int right=high;
        int key=arr[left];
        while(left<right){

            while(left<right && arr[right]>=key){
                right--;
            }

            while(left<right && arr[left]<=key){
                left++;
            }
            swap(arr,left,right);
        }
        swap(arr,low,left);
        return left;
    }
    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] a={13701823,17092337,31693639,42607214,54807658,64838842,70309112,77481420,82447697,84356804,109686701,111935818,119093579,151485185,157540946,158982405,169670404,177571868,193715454,215386675,219297819,230964510,241316335,256184773,261627544,280992325,281397572,292446044,294497342,298738196,303753633,306242389,340316511,353487181,387052570,393354006,411203381,421701576,427514727,427529125,433183457,433518449,440403918,445747969,453463919,462370265,472147510,480363996,493886311,513023688,521612397,536343860,537616843,544069623,544526209,546931356,570872277,586696306,604354651,631219735,631784130,633020080,641532230,659978110,691252458,693597252,695760794,698504118,714012242,728999048,733048764,738026287,738644784,740856884,764532283,768122842,782703840,784337461,784607555,805374069,819959858,830140516,830623614,861262547,884642435,884688278,885254231,915272981,917959651,918973856,937296273,946770900,965184299,970050582,970466103,978672815,984427390,986263711,995773975,998857732};
        int[] res=MySort(a);
        System.out.println(Arrays.toString(res));
    }
}
