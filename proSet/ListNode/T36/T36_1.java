package LeetCode1.LIST.ListNode.offer.T36;

public class T36_1 {
    //方法二：在中序遍历过程中，将节点串成双链表
    Node pre,head;
    public Node treeToDoublyList(Node root) {
        if (root==null){
            return null;
        }
        inOrder(root);
        //首尾相接
        head.left=pre;
        pre.right=head;
        return head;
    }

    private void inOrder(Node cur) {
        if (cur ==null){
            return;
        }
        //递归左孩子
        inOrder(cur.left);
        //处理节点关系
        if (pre==null){
            head= cur;
        }else {
            //先建立单指向关系
            pre.right=cur;
        }
        //设置前驱后继
        cur.left=pre;
        pre=cur;
        inOrder(cur.right);
    }


}
