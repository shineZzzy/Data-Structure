package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo4 {
    public static void main(String[] args) {

        List<String> list=new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        //调用list的迭代器，返回类型是Iterator类型的迭代器。
        Iterator<String> it =list.iterator();
        while (it.hasNext()){
            String next=it.next();
            if(next.equals("D")) {
                list.remove("D");
            }
        }
        System.out.println(list);
    }
}
