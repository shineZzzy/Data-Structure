package DataStructure.LinkedList;
public class LinkedListTest {
    public static void main(String[] args) {
        List list=new LinkedList();
        list.add(31);
        list.add(32);
        list.add(33);
        list.add(34);
//        System.out.println(list);
        list.add(0, 998);
        list.add(31);
        list.add(32);
        list.add(33);
//        System.out.println(list);   // [998, 31, 32, 33]

        list.add(0, 1000);
//        System.out.println(list);   // [1000, 998, 31, 32, 33]
        list.add(3, 28);
//        System.out.println(list);   // [1000, 998, 31, 28, 32, 33]
        list.add(1, 98);
//        System.out.println(list);   // [1000, 98, 998, 31, 28, 32, 33]
        list.add(7, 2000);
        System.out.println(list);   // [1000, 98, 998, 31, 28, 32, 33, 2000]

        System.out.println(list.remove(3));
        System.out.println("remove1:"+list);
        System.out.println(list.remove((Integer) 32));
        System.out.println("remove2:"+list);
        System.out.println(list.remove((Integer) 2));
        System.out.println("remove3:"+list);
        list.set(3,1001);
        System.out.println("set:"+list);
        System.out.println("get:"+list.get(3));
        System.out.println(list.indexOf(2000));
        System.out.println(list.lastIndexOf(28));

//        Iterator it= (Iterator) list.iterator();
//        while (it.hasNext()){
//            System.out.print(it.next()+" ");
//        }
    }

}
