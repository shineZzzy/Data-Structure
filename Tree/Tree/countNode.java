package DataStructure.Tree;


public class countNode {
    private static int n;
    public static int sumNode(TreeNode root){
        n=0;
        preOrder(root);
        return n;
    }
    public static void preOrder(TreeNode root){
        if (root!=null){
            n++;
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    //所有节点=根节点+左子树节点+右子树节点
    public static int sumTreeNode(TreeNode root){
        if (root==null){
            return 0;
        }else {
            int rootSize=1;
            int leftSize=sumTreeNode(root.left);
            int rightSize=sumTreeNode(root.right);
            return rootSize+leftSize+rightSize;
        }
    }

    //遍历
    public static int sumLeaf(TreeNode root){
        n=0;
        preLeaf(root);
        return n;
    }

    private static void preLeaf(TreeNode root) {
        if (root!=null){

            if (root.left==null && root.right==null){
                n++;
            }
            preOrder(root.left);
            preOrder(root.right);
        }

    }

    //所有叶子节点=右子树叶子+左子树叶子
    public static int sumLeaves(TreeNode root){
        if (root==null){
            return 0;
        }else if (root.left==null && root.right==null){
            return 1;
        }else {
            int left=sumLeaves(root.left);
            int right=sumLeaves(root.right);
            return left+right;
        }
    }

    //求第K层节点个数
    public static int sumLevel(TreeNode root,int k){
        if (root==null){
            //1.空树情况
            return 0;
        }else if (k==1){
            //2.只有1层，说明只有一个根节点
            return 1;
        }else {
            //3.儿女双全
            int kLeft=sumLevel(root.left,k-1);
            int kRight=sumLevel(root.right,k-1);
            return kLeft+kRight;
        }
    }

    //求二叉树的高度
    public static int depthTree(TreeNode root){
        //求根+max(左子树高度,右子树高度)
        if (root==null){
            return 0;
        }else if (root.left==null && root.right==null){
            return 1;
        }else {
            int depthRoot=1;
            int depthLeft=depthTree(root.left);
            int depthRight=depthTree(root.right);
            return depthRoot+Math.max(depthLeft,depthRight);
        }
    }

    //求该二叉树中是否包含指定V
    public static boolean containsV(TreeNode root,int v){
        if (root==null){
            return false;
        }else {
            if (root.v==v){
                return true;
            }else {
                boolean leftContains=containsV(root.left,v);
                //如果左子树找到了
                if (leftContains){
                    return true;
                }else {
                    //左子树没找到就去右子树找
                    boolean rightContains=containsV(root.right,v);
                    if (rightContains){
                        return true;
                    }
                }
            }
        }
        //左右子树都没有，根也没有，false
        return false;
    }

    public static boolean containsV2(TreeNode root,int v){
        if (root==null){
            return false;
        }
        //树不是空
        if (root.v==v){
            return true;
        }

        boolean leftContains=containsV2(root.left,v);
        if (leftContains){
            return true;
        }
        //优化，如果右子树包含就是true，不包含就是false
        return containsV2(root.right,v);
    }
    //查找V是否包含在二叉树中，如果是返回该节点
    public static TreeNode containsV3(TreeNode root,int v){
        //定义返回的特殊值
//        TreeNode node=new TreeNode(-1);
        if (root==null){
            return null;
        }

        if (root.v==v){
            return root;
        }

        //1.左子树找
        //2.左子树没有，去右子树找
        TreeNode left=containsV3(root.left,v);
        //优化
        if (left!=null){
            return left;
        }
        return containsV3(root.right,v);
//        if (left == null){
//            TreeNode right=containsV3(root.right,v);
//            if (right==null){
//                return null;
//            }else {
//                return right;
//            }
//        }else {
//            return left;
//        }
    }

    //查找node是否是本二叉树上的节点,是同一个节点不是值相等的节点
    public static TreeNode containsNode(TreeNode root,TreeNode node){
        if (root==null){
            return null;
        }
        if (root==node){
            return root;
        }

        TreeNode left=containsNode(root.left,node);
        if (left!=null){
            return left;
        }
        return containsNode(root.right,root);
    }

    public static void main(String[] args) {
        TreeNode root=BuildTree.buildTree1();
        TreeNode r=containsNode(root,root);
        System.out.println(r);

        TreeNode res=containsNode(root,new TreeNode('A'));
        System.out.println(res);
        TreeNode rest=containsNode(root,new TreeNode('Z'));
        System.out.println(rest);



//        int res=sumTreeNode(root);
//        int res=sumNode(root);
//        int res=sumLeaves(root);
//        int k=4;
//        int res=sumLevel(root,k);
//        System.out.println("树的K层节点数为："+res);
//        System.out.println("树的3层节点数为："+sumLevel(root, 3));
//        System.out.println("树的2层节点数为："+sumLevel(root, 2));
//        System.out.println("树的1层节点数为："+sumLevel(root, 1));
//
//        int res=depthTree(root);
//        System.out.println(res);

//        boolean res=containsV2(root,'Y');
//        boolean res1=containsV2(new TreeNode('X'),'Z');
//        System.out.println(containsV2(null, 'A'));
//        System.out.println(res);
//        System.out.println(res1);

//        System.out.println(containsV3(null, 'A').v);
//        System.out.println(containsV3(new TreeNode('A'), 'A').v);
//        System.out.println(containsV3(root, 'A').v);
//        TreeNode v=containsV3(root, 'X');
//        System.out.println(v);
//        System.out.printf("%c%n",v.v);

//        System.out.println(containsV3(root, 'F').v);
//        System.out.println(containsV3(root, 'Z').v);
    }
}
