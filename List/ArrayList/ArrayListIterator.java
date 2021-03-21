package DataStructure.ArrayList;

public class ArrayListIterator implements Iterator{

    private ArrayList arrayList;
    private int index;//当前下标



    public ArrayListIterator(ArrayList arrayList) {
        this.arrayList = arrayList;
        this.index=0;
    }


    @Override
    public boolean hasNext() {
        return index<arrayList.size();
    }

    /**
     *1.返回迭代器当前所在位置的元素
     * 2.让迭代器走到下一个位置上
     */
    @Override
    public Integer next() {
        return arrayList.get(index++);
    }

    @Override
    public void remove() {

    }
}
