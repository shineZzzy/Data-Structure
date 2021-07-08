package LeetCode1.LIST.ListNode.offer.T36;

import java.util.ArrayList;
import java.util.List;



/**
 * 二叉搜索树和双向链表
 * 描述：将该二叉搜索树转换成一个排序的循环双向链表
 * TIP：不允许创建新节点，只能改变节点关系
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * 特点：二叉搜索树的中序遍历有序
 */
public class T36 {
    //方法一：对二叉搜索树进行中序遍历，存储所有节点，设置节点指向关系
    public static List<Integer> array=new ArrayList<>();
    public static Node treeToDoublyList(Node root) {
        if (root==null){
            return null;
        }
        Node pre=null;
        Node head=null;
        List<Node> list=new ArrayList<>();
        inOrder(root,list);
        int size=list.size();
        //先建立单链表指向关系
        for (int i = 0; i < size; i++) {
            Node cur=list.get(i);
            array.add(cur.val);
            if (head==null){
                head=cur;
            }
            cur.left=pre;
            if (i+1==size){
                pre=cur;
                break;
            }
            cur.right=list.get(i+1);
            pre=cur;
        }
        //首尾相接！
        head=list.get(0);
        head.left=pre;
        pre.right=head;

        return head;
    }
    //中序遍历
    private static void inOrder(Node root, List<Node> list) {
        if (root==null){
            return;
        }
        inOrder(root.left,list);
        list.add(root);
        inOrder(root.right,list);
    }

    public static void main(String[] args) {
        Node root=new Node(4);
        Node a=new Node(2);
        Node b=new Node(5);
        Node c=new Node(1);
        Node d=new Node(3);

        root.left=a;
        root.right=b;
        a.left=c;
        a.right=d;

        treeToDoublyList(root);
        System.out.println(array);

    }
}
