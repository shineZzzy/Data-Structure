package BstTest;

//insert
public class BST {
    private Node root;
    public BST(){
        root = null;
    }
    public boolean search(Integer key){
        //search
        // 1.定义一棵空树
        //2.查找。3种情况：
        Node cur=root;
        while(cur!=null){
            int cmp=key.compareTo(cur.key);
            if(cmp==0){
                return true;
            }else if(cmp<0){
                cur=cur.left;
            }else {
                cur=cur.right;
            }
        }

        // ==key ---return true
        // >key  ---cur=cur.left
        // <key  ---cur=cur.right
        //3.当cur == null 结束
        //4.两个出口 == key/cur == null
        return false;
    }
    public void insert(Integer key){
        if(root==null){
            root=new Node(key);
            return;
        }
        //1.定义一个cur的双亲结点parent，始终位置关系
        Node parent=null;
        Node cur=root;
        //2.当cur!=null时，比较key与树中key确定插入位置
        int cmp=0;
        while (cur!=null){
            cmp=key.compareTo(cur.key);
            if(cmp==0){
                //抛异常
                throw new RuntimeException("key不可重复");
            }else if(cmp<0){
                //走左子树
                parent=cur;
                cur=cur.left;
            }else {
                parent=cur;
                cur=cur.right;
            }
        }
        //3.不允许重复key出现
        //4.根据判断cmp，决定插入(但无法确定node == null 情况)
        Node node=new Node(key);
        if(cmp < 0){
            parent.left=node;
        }else {
            parent.right=node;
        }
    }

}
