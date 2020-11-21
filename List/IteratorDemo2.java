package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//验证存在多个Iterator时，是否独立
public class IteratorDemo2 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        Iterator<String> it =list.iterator();
        Iterator<String> it2 =list.iterator();

        it.next();
        it.next();
        System.out.println(it.next());
        System.out.println(it2.next());
    }
}
