package DataStructure.ArrayList;

public interface List extends Iterable{
    boolean add(Integer e);
    void add(int index,Integer e);

    int remove(int index);
    boolean remove(Integer element);

    Integer get(int index);
    Integer set(int index,Integer e);

    int size();
    void clear();
    boolean isEmpty();

    boolean contains(Integer e);
    int indexOf(Integer e);
    int lastIndexOf(Integer e);



}
