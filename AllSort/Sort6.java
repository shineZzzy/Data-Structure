package AllSort;

import java.util.HashMap;

public class Sort6 {
    public static void swap(long[] array,int index1,int index2){
        long t=array[index1];
        array[index1]=array[index2];
        array[index2]=t;
    }
    public static void quickSort(long[] array){
        //第一次快排，从0-(arr.len-1)对arr进行排序
        quickSortInternal(array,0,array.length-1);
    }
    public static void quickSortInternal(long[] array,int lowIndex,int highIndex){

        //5.终止条件：size=0/1
        int size=highIndex-lowIndex+1;
        if(size<=1){
            return;
        }
        //1.从无序数组中选出一个key值
        //一般选最左边的值，即arr[lowIndex]
        //2.对序列做partition
        //3.并得到partition后key值所在下标
        int keyIndex=partition(array,lowIndex,highIndex);
        //4.对partition后的两个区间分别重复上述过程
        //左区间：[lowIndex,keyIndex-1]
        //右区间：[keyIndex+1,highIndex]
        quickSortInternal(array,lowIndex,keyIndex-1);
        quickSortInternal(array,keyIndex+1,highIndex);
    }
    //partition思想
    //1.选择arr[lowIndex]作为key
    //2.遍历整个区间(不能遗漏)和选出来的key
    //3.保证partition后，小于等于key的居左，大于(等于)的居右（左右区间内不要求有序）
    //4.区间范围：[lowIndex,highIndex]
    public static int partition(long[] array,int lowIndex,int highIndex) {
        return partitionDig(array, lowIndex, highIndex);
    }
    public static int partitionHoare(long[] array,int lowIndex,int highIndex){
        //1.利用下标截取一段区间
        int leftIndex=lowIndex;
        int rightIndex=highIndex;
        //2.选择最左边的数作为key
        long key=array[lowIndex];
        //3.从右边开始遍历
        while (leftIndex<rightIndex){
            //4.确定终止条件
            // 当leftIndex == rightIndex时，停止循环
            //但在左右“指针”遍历时，下标始终变化，可能会越过上述条件
            //需要再次加强约束
            while (leftIndex<rightIndex && array[rightIndex]>=key){
                rightIndex--;
            }
            while (leftIndex<rightIndex && array[leftIndex]<=key){
                leftIndex++;
            }
            //当遍历停止，左右交换
            swap(array,leftIndex,rightIndex);
        }
        //5.令lowIndex和leftIndex下标的数就行交换，开启下一轮
        swap(array,lowIndex,leftIndex);
        //6.当前最左边的数的下标为leftIndex
        return leftIndex;
    }
    public static int partitionDig(long[] array,int lowIndex,int highIndex){
        //1.
        int leftIndex=lowIndex;
        int rightIndex=highIndex;
        //2.key
        long key=array[lowIndex];
        //3.将key挖出来
        //4.遍历
        while (leftIndex<rightIndex){
            //4.确定终止条件
            // 当leftIndex == rightIndex时，停止循环
            //但在左右“指针”遍历时，下标始终变化，可能会越过上述条件
            //需要再次加强约束
            while (leftIndex<rightIndex && array[rightIndex]>=key){
                rightIndex--;
            }
            //停下来时，找到更小的，填入左边的坑(lowIndex位置上站的是leftIndex)
            array[leftIndex]=array[rightIndex];
            while (leftIndex<rightIndex && array[leftIndex]<=key){
                leftIndex++;
            }
            //当遍历停止，左右交换
            array[rightIndex]=array[leftIndex];
        }
        //当 leftIndex == rightIndex时，将key填入坑中
        array[leftIndex]=key;

        return leftIndex;
    }
    public static int partitionPreNex(long[] array,int lowIndex,int highIndex){
        //定义一个分隔下标
        int separate=lowIndex+1;
        //令pre下标现走，遍历所有数，遇到小于key的停下来
        //与separate所指位置元素交换
        //并使separate向前走一步
        //循环往复，直至pre下标遍历完
        for(int i=lowIndex+1;i<=highIndex;i++){
            if(array[i]<array[lowIndex]){
                array[i]=array[separate];
                separate++;
            }
        }
        //当pre下标遍历完，使separate所指元素和key(最左边的元素)交换
        swap(array,lowIndex,separate-1);
        //返回原最左边元素的下标
        return separate-1;
    }
    public static int partitionTwos(long[] array,int lowIndex,int highIndex){
        //1.利用下标截取一段区间
        int leftIndex=lowIndex;
        int rightIndex=highIndex;
        //2.选择最左边的数作为key
        long key=array[lowIndex];
        //3.从右边开始遍历
        while (leftIndex<rightIndex){
            //4.确定终止条件
            // 当leftIndex == rightIndex时，停止循环
            //但在左右“指针”遍历时，下标始终变化，可能会越过上述条件
            //需要再次加强约束
            while (leftIndex<rightIndex && array[rightIndex]%2!=0){
                rightIndex--;
            }
            while (leftIndex<rightIndex && array[leftIndex]%2==0){
                leftIndex++;
            }
            //当遍历停止，左右交换
            swap(array,leftIndex,rightIndex);
        }
        //5.令lowIndex和leftIndex下标的数就行交换，开启下一轮
        swap(array,lowIndex,leftIndex);
        //6.当前最左边的数的下标为leftIndex
        return leftIndex;
    }
    //归并排序
    public static void mergeSort(long[] array){
        mergeSortInternal(array,0,array.length);
    }
    //区间：左闭右闭
    public static void mergeSortInternal(long[] array,int lowIndex,int highIndex){
        //1.现将序列拆分成两个相等大小序列
        int size=highIndex-lowIndex;
        //出口1，当序列没有元素后只剩一个元素，证明已经拆分完了
        if(size<=1){
            return;
        }
        //定义一个中间下标，用去拆分序列
        int middleIndex = (lowIndex+ highIndex)/2;
        //左区间：[lowIndex,middleIndex)
        //右区间：[middleIndex,highIndex)
        //2.递归两个序列，使之有序
        mergeSortInternal(array,lowIndex,middleIndex);
        mergeSortInternal(array,middleIndex,highIndex);
        //3.合并序列
        merge(array,lowIndex,middleIndex,highIndex);
    }
    private static void merge(long[] array,int lowIndex,int middleIndex,int highIndex){
        //1.确定序列长度，定义一个额外数组
        int size=highIndex-lowIndex;
        long[] extraArray = new long[size];
        //2.定义三个指针，分别是左右序列+额外数组
        int leftIndex = lowIndex;
        int rightIndex = middleIndex;
        int extraIndex = 0;
        //3.合并数组到额外数组
        //当两个队伍都有人
        while (leftIndex < middleIndex && rightIndex > highIndex){
            if(array[leftIndex]<=array[rightIndex]){
                extraArray[extraIndex]=array[leftIndex];
                extraIndex++;
                leftIndex++;
            }else {
                extraArray[extraIndex]=array[rightIndex];
                extraIndex++;
                rightIndex++;
            }
        }
        //一个队伍空了
        //若右队伍空了，将左队伍元素都搬入额外数组
        if(leftIndex<middleIndex){
            while (leftIndex<middleIndex){
                extraArray[extraIndex]=array[leftIndex];
            }
        }else {
        //左队伍空了，将右队伍元素都搬入额外数组
            while (rightIndex<highIndex) {
                extraArray[extraIndex] = array[rightIndex];
            }
        }
        //4.将排好序的数据搬回原数组
        //额外数组 [0,size)
        //搬回去的下标范围[lowIndex,highIndex)
        for(int i=0;i<size;i++){
            array[i+lowIndex]=extraArray[i];
        }
    }
}
