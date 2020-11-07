package Tree;

public class RemoveTest {
    //1.删除的key不在BST中
    public static void case1(){
        BST bst=new BST();
        bst.insert(5);
        //expect：1.返回false 2.树不变化
        //actual：
        System.out.println(bst.remove(3));
    }
    //2.只有一个叶子结点的BST，删除该结点
    public static void case2(){
        BST bst=new BST();
        bst.insert(5);
        //expect：1.true 2.变成空树
        boolean remove=bst.remove(5);
        System.out.println(remove);
    }
    //3.删除一个叶子，是双亲的左孩子
    public static void case3(){
        BST bst=new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);

        boolean remove =bst.remove(3);
        System.out.println(remove);

    }

    //4.删除一个叶子，是双亲的右孩子
    public static void case4(){
        BST bst=new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);



        boolean remove =bst.remove(6);
        System.out.println(remove);

    }
    //5.删除根，但没有右孩子
    public static void case5(){
        BST bst=new BST();
        bst.insert(5);
        bst.insert(3);

        boolean remove =bst.remove(3);
        System.out.println(remove);

    }

    //6.删除一个没有右孩子的结点，是双亲的左孩子
    public static void case6(){
        BST bst=new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);
        bst.insert(1);


        boolean remove =bst.remove(3);
        System.out.println(remove);

    }
    //7.删除一个没有右孩子的结点，是双亲的右孩子
    public static void case7(){
        BST bst=new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(6);



        boolean remove =bst.remove(6);
        System.out.println(remove);

    }
    //8.删除根，但没有左孩子
    public static void case8(){
        BST bst=new BST();
        bst.insert(5);
        bst.insert(6);

        boolean remove =bst.remove(5);
        System.out.println(remove);
    }
    //9.删除一个没有左孩子的结点，是双亲的左孩子
    public static void case9(){
        BST bst=new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);
        bst.insert(8);
        bst.insert(4);


        boolean remove =bst.remove(3);
        System.out.println(remove);

    }
    //10.删除一个没有左孩子的结点，是双亲的右孩子
    public static void case10(){
        BST bst=new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(6);
        bst.insert(8);


        boolean remove =bst.remove(6);
        System.out.println(remove);

    }
    //11.替换法情况一，node的左孩子没有右孩子
    public static void case11(){
        BST bst=new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(6);
        bst.insert(8);


        boolean remove =bst.remove(3);
        System.out.println(remove);

    }
    //12.替换法情况二，node的左孩子有右孩子
    public static void case12(){
        BST bst=new BST();
        bst.insert(5);
        bst.insert(3);
        bst.insert(7);
        bst.insert(6);
        bst.insert(8);
        bst.insert(4);


        boolean remove =bst.remove(5);
        System.out.println(remove);

    }
    //13.尝试删除根的情况
    public static void case13(){
        BST bst=new BST();
        bst.insert(4);
        bst.insert(2);
        bst.insert(7);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(8);
        bst.insert(6);


        boolean remove =bst.remove(4);
        System.out.println(remove);

    }


    public static void main(String[] args) {
        case13();
    }
}
