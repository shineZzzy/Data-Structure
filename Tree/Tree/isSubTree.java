package DataStructure.Tree;

public class isSubTree {
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p==null && q==null){
            return true;
        }
        if (p==null || q==null){
            return false;
        }
        return p.v==q.v
                && isSameTree(p.left,q.left)
                && isSameTree(p.right,q.right);
    }


    //查找
    public static boolean search(TreeNode s, TreeNode t) {
        if (s==null){
            return false;
        }
        if (s.v==t.v){
            if (isSameTree(s,t)){
                return true;
            }
        }
        if (search(s.left,t)){
            return true;
        }
        return search(s.right,t);
    }
    //找孩子
    public static boolean isSubtree(TreeNode s, TreeNode t) {
        return search(s,t);
    }
}
