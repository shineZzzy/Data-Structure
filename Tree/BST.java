package Tree;

import javax.management.RuntimeErrorException;

public class BST {
    public Node root;
    //查找
    public boolean search(Integer key){
        Node current=root;
        while (current!=null){
            int cmp=key.compareTo(current.key);
            if(cmp==0){
                return true;
            }else if(cmp<0){
                current= current.left;
            }else {
                current= current.right;
            }
        }
        return false;
    }
    //插入
    public void insert(Integer key) {
        if(root==null){
            root=new Node(key);
            return;
        }
        //先找到待插入key应该在树中所处的位置
        Node parent=null;
        Node current=root;
        int cmp=0;
        while (current!=null){
            cmp=key.compareTo(current.key);
            //3种情况
            if(cmp==0){
                throw new RuntimeException("BST中不允许出现重复key！");
            }else if(cmp<0){
                parent=current;
                current=current.left;
            }else {
                parent=current;
                current=current.right;
            }
        }
        //插入
        Node node=new Node(key);
        if(cmp<0){
            parent.left=node;
        }else {
            parent.right=node;
        }
    }

    //删除
    public boolean remove(Integer key){
//        Node node=new Node(key);
        Node parent=null;
        Node current=root;
        //找待删除的结点
        while (current!=null){
            int cmp=key.compareTo(current.key);
            if(cmp==0){
                removeInternal(current,parent);
                return true;
            }else if(cmp<0){
                parent=current;
                current=current.left;
            }else {
                parent=current;
                current=current.right;
            }
        }
        return false;
    }

    private void removeInternal(Node node,Node parent){
        if(node.left==null && node.right==null){
            if(node==root){
                root=null;
            }else if(node==parent.left){
                parent.left=null;
            }else {
                parent.right=null;
            }
        } else if (node.left!=null && node.right==null){
            if(node==root){
                root=root.left;
            }else if(node==parent.left){
                parent.left=node.left;
            }else {
                parent.right=node.left;
            }
        } else if(node.left==null && node.right!=null){
            if(node==root){
                root=root.root;
            }else if(node==parent.left){
                parent.left=node.right;
            }else {
                parent.right=node.right;
            }
        }else {
            //替换法
            Node ghostParent=node;
            Node ghost=node.left;
            //先找到左子树中最大的结点
            while (ghost.right!=null){
                ghostParent=ghost;
                ghost=ghost.right;
            }
            //开始替换
            node.key=ghost.key;
            //删除ghost孩子结点(孩子的右孩子为null)
            if(node==ghostParent){
                ghostParent.left=ghost.left;
            }else {
                ghostParent.right=ghost.left;
            }
        }
    }




}
