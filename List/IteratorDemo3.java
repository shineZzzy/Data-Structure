package List;

import java.util.ArrayList;
import java.util.List;

public class IteratorDemo3 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        for(String next:list){
            if (next.equals("C")) {
                list.remove("C");
            }
        }
        System.out.println(list);
    }
}
