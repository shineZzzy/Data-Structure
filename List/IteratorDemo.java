package List;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {
    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        //调用list的迭代器，返回类型是Iterator类型的迭代器。
        Iterator<String>it =list.iterator();
        while (it.hasNext()){
            //取到it的每一个值，返回String类型
            String next=it.next();
            System.out.println(next);
        }

        //上述写法会被替换成foreach写法
        //foreach本质上用迭代器实现的
        //凡是支持Iterable能力的容器，都可以用foreach
        for(String next:list){
            System.out.println(next);
        }


    }
}
