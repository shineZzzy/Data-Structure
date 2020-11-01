package Sort;

import java.util.Arrays;
import java.util.Random;

public class Sort5 {
    //交换
    public static void swap(long[] array,int n,int p){
        long t=array[n];
        array[n]=array[p];
        array[p]=t;
    }
    //选择排序
    public static void selectSort(long[] array){
        //排序次数
        for(int i=0;i<array.length-1;i++){
            //最大数
            //假设初始最大值的下标为0；
            int maxIndex=0;
            //无序：[0,arr.len-i)
            //有序：[arr.len-i,arr.len)
            //遍历无序区间，与最大值比较，找到新的最大值，与之交换
            for(int j=1;j<array.length-i-1;j++){
                if(array[j]>array[maxIndex]){
                    maxIndex=j;
                }
            }
            //将最大值与无序区间最后一个元素交换
            swap(array,maxIndex,array.length-i-1);
        }
    }
    //优化
    public static void selectSort2(long[] array){
        for(int i=0;i<array.length-1;i++){
            //假设初始最值的下标为0；
            int maxIndex=0;
            int minIndex=0;
            //无序：[0,arr.len-i)  有序：[arr.len-i,arr.len)
            //遍历无序区间，与最值比较，找到新的最值
            for(int j=1;j<array.length-i-1;j++){
                if(array[j]>array[maxIndex]){
                    maxIndex=j;
                }
                if (array[j]<array[minIndex]){
                    minIndex=j;
                }
            }
            //将最大值与无序区间最后一个元素交换
            swap(array, maxIndex, array.length - i - 1);
            //将最小值与无序区间第一个元素交换
            swap(array, minIndex, 0);
        }
    }
    //堆排序
    public static void heapSort(long[] array){
        //建大堆
        createHeap(array,array.length);
        //遍历数组
        for(int i=0;i<array.length-1;i++){
            //用最后一个元素替换堆顶元素
            swap(array,0,array.length-i-1);
            //向下调整
            adjustDown(array,array.length-i-1,0);
        }
    }
    public static void adjustDown(long[] array,int size,int index) {
//        while(2*index+1<size) {
//            int maxIndex = 2 * index + 1;//左孩子
//            //如果右孩子存在，且大于左孩子，则最大值为右孩子
//            if(maxIndex+1<size && array[maxIndex+1]>array[maxIndex]){
//                maxIndex++;
//            }
//            //如果当前值大于最大值
//            if(array[index]>=array[maxIndex]){
//                break;
//            }
//            swap(array,maxIndex,index);
//
//            index=maxIndex;
//        }
//    }
        //1.先判断index是否为叶子结点，是，则return；
        //2.找到两个孩子中最小孩子
        //3.将最小孩子与index进行比较
        //满足堆性质，直接return
        //不满足，则交换
        //4.将最小孩子视为新的index，继续循环
        int leftIndex=2*index+1;
        //1.
        if (leftIndex>size){
            return;
        }
        //2.
        while (leftIndex<size){
            int maxIndex=leftIndex;
            if(maxIndex+1<size && array[maxIndex+1]>array[maxIndex]){
                maxIndex=maxIndex+1;//右孩子为最大孩子
            }
            if(array[index] >= array[maxIndex]){
                return;
            }
            //3.
            swap(array,maxIndex,index);
            //4.
            index=maxIndex;
        }
    }
    public static void createHeap(long[] array,int size){
        //找到层序遍历的最后一个节点下标
        int lastIndex=size-1;
        //找到最后一个节点的父节点下标
        int lastParentIndex=(lastIndex-1)/2;
        //从[lastParentIndex,0]不断向下调整
        for(int i=lastParentIndex;i>=0;i--){
            adjustDown(array,size,i);
        }

    }
    //shellSort
    public static void inserSortGap(long[] array,int gap){
        //大循环，排序array.leng-1组
        for(int i=0;i<array.length-1;i++){
            //抓取i值
            long key=array[i];
            //遍历有序组，令key与j比较
            int j=0;
            for(j=i-gap;j>=0;j=j-gap){
                if(key<array[j]){
                    //如果key值小于j，则进行i.j交换.(key=i=j+gap)
                    array[j+gap]=array[j];
                }else {
                    break;
                }
            }
            //若key>=array[j],就尾插到i(j+gap)后面
            array[j+gap]=key;
        }
    }
    public static void shellSort(long[] array){
        //定义初始分组
        int gap=array.length/2;
        while(true){
            //对数组进行分组插排
            inserSortGap(array,gap);
            //gap变化，当gap==1即可退出，此时已有序
            if(gap==1){
                break;
            }
            //若不等于1，则计算新的gap,进行循环
            gap=gap/2;
        }
    }


    //测试
    public static long[] 随机数组(){
        Random random=new Random(20201018);//随机种子
        long[] array=new long[10];
        for(int i=0;i<10;i++){
            array[i]=random.nextInt(100);
        }
        return array;
    }

    public static void main(String[] args) {
        long[] a=随机数组();
        System.out.println(Arrays.toString(a));
        selectSort2(a);
//        selectSort(a);
        System.out.println(Arrays.toString(a));
    }

}
