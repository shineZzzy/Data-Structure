package DataStructure.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        System.out.println(list);
        System.out.println(list.size());

//        System.out.println(list.remove(2));
//        System.out.println(list.remove((Integer) 2));
//        System.out.println(list);
//        list.add(0,101);
//        list.set(5,666);
//        System.out.println(list);
//        try {
//            list.add(-1,200);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        System.out.println(list);
//        try {
//            list.add(7,300);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//        System.out.println(list);
//
//        try {
//            list.remove(6);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        System.out.println(list.get((Integer)2));
//        System.out.println(list);
//        try {
//            list.get(-1);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        System.out.println(list.set(3, 2000));
//        System.out.println(list);
//
//        list.clear();
//        System.out.println(list.isEmpty());
//        System.out.println(list);
//
//        for (int i = 1; i < 11; i++) {
//            list.add(i);
//        }
//        System.out.println(list);
//        //扩容了
//        list.add(1);
//        System.out.println(list);
//        System.out.println(list.indexOf(1));
//        System.out.println(list.lastIndexOf(1));
//        System.out.println(list.indexOf(99));
//        System.out.println(list.lastIndexOf(99));
//        System.out.println(list.indexOf(3));
//        System.out.println(list.contains(99));
//        System.out.println(list.contains(8));
//
//
//        //复制
//        List l2=new ArrayList(list);
//        System.out.println("list: "+list);
//        System.out.println(list.size());
//        System.out.println("l2: "+l2);
//        System.out.println(l2.size());
//
//        List l3=list;//俩引用指向同一对象了
//        l3.set(0,10000);
//        System.out.println("list: "+list);
//        System.out.println("l2: "+l2);
//        System.out.println("l3: "+l3);

        Iterator it=list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
