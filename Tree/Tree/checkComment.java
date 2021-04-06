package DataStructure.Tree;
//注意善于利用树的递归定义思想。
public  class checkComment {
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


    //镜像树
    public boolean isSymmetric(TreeNode root) {
        return check(root.left,root.right);
    }
    public boolean check(TreeNode p,TreeNode q){
        //1.情况1：两树都为空
        if(p==null && q==null){
            return true;
        }
        //2.情况2：有一树不为空
        if(p==null || q==null){
            return false;
        }
        //3.情况3：左右子树都不为空
        //如果要为镜像树需要同时满足三个条件：
        //1.根节点相等
        //2.q的左子树和p的右子树相同
        //3.p的左子树和q的右子树相同
        return p.v==q.v
                && check(p.left,q.right)
                && check(p.right,q.left);
    }
    public static void main(String[] args) {
        TreeNode p=BuildTree.buildTree2();
        TreeNode q=BuildTree.buildTree2();
        boolean res=isSameTree(p,q);
        System.out.println(res);
    }
}
