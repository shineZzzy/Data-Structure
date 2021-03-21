package DataStructure.ArrayList;


import java.util.Arrays;

public class ArrayList implements List{

    private int[] array;
    private int size;


    public ArrayList(){
        //初始化数组
        array=new int[10];
        size=0;
    }
    //复制
    public ArrayList(List other){
        array=new int[other.size()];
        for (int i = 0; i < other.size(); i++) {
            array[i]=other.get(i);
        }
        size=other.size();
    }


    @Override
    public boolean add(Integer e) {
        //TODO 扩容
        if (array.length==size){
            //已经满了，扩容
            ensureCapacity(array.length*2);
        }
        //默认尾插
        array[size++]=e;
        return true;
    }

    //调用完该方法后，要保证容量一定大于=capacity
    public void ensureCapacity(int capacity){
        if (array.length>=capacity){
            return;
        }
        //1.开辟先数组
        int[] newArray=new int[capacity];
        //2.搬家
        for (int i = 0; i <size ; i++) {
            newArray[i]=this.array[i];
        }
        //3.不在关联老的array，关联新的array
        this.array=newArray;

    }

    //通常时间复杂度为o(1)
    //扩容时，时间复杂度为o(n)
    //但扩容情况较少，所有该方法的时间复杂度一般被称为平均o(1)
    @Override
    public void add(int index, Integer e) {
        //下标插入O(n)，为保证元素不被覆盖，后面的先开始搬
        //合法下标[0,size]
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("下标不合法"+index);
        }

        if (array.length==size){
            //已经满了，扩容
            ensureCapacity(array.length*2);
        }

        for (int i = size; i >index; i--) {
            array[i]=array[i-1];
        }
        array[index]=e;
        size++;
    }

    @Override
    public int remove(int index) {
        //下标合法检验
        if (index<0 || index>=size){
            throw new IndexOutOfBoundsException("下标不合法"+index);
        }
        //下标删
        int e=array[index];
        //从前往后删  [index+1,size-1]--->[index,size-2]
        for (int i=index+1;i<=size-1;i++){
            array[i-1]=array[i];
        }
        size--;
        return e;
    }

    @Override
    public boolean remove(Integer e) {
        //删元素
        for (int i=0;i<size;i++){
            if (array[i]==e){
                remove(i);
                return true;
            }
        }
        return false;


        //方法2
//        int index=indexOf(e);
//        if (index!=-1){
//            remove(index);
//            return true;
//        }else {
//            return false;
//        }
    }

    @Override
    public Integer get(int index) {
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("下标不合法"+index);
        }

        return array[index];
    }

    @Override
    public Integer set(int index, Integer e) {
        //放入后，返回原来的值
        if (index<0 || index>size){
            throw new IndexOutOfBoundsException("下标不合法"+index);
        }
        Integer old=array[index];
        array[index]=e;
        return old;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        //清空，置size为0
        Arrays.fill(array,-1);
        size=0;
    }

    @Override
    public boolean isEmpty() {
        return size()==0;
    }

    @Override
    public boolean contains(Integer e) {
        return indexOf(e)!=-1;
    }

    @Override
    public int indexOf(Integer e) {
        //第一次出现的位置，从前往后遍历
        for (int i = 0; i <size ; i++) {
            if (array[i]==e){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        //最后一次出现的位置，从后往前遍历
        for (int i = size-1; i>=0; i--) {
            if (array[i]==e){
                return i;
            }
        }
        return -1;
    }


    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i!=size-1){
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //通过实现Iterator方法，体现出具备迭代能力，可以返回迭代器
    @Override
    public ArrayListIterator iterator() {
        return new ArrayListIterator(this);
    }
}
