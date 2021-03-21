package DataStructure.ArrayList;

//仿写真实的迭代器
public interface Iterator {
    boolean hasNext();
    Integer next();
    void remove();
}
