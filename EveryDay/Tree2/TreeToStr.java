package LeetCode.Tree2;

public class TreeToStr {
    public static String tree2str(TreeNode t) {
        StringBuilder sb=new StringBuilder();
        preOrder(t, sb);
        return sb.toString();
    }

    private static void preOrder(TreeNode t, StringBuilder sb) {
        if(t!=null) {
            sb.append(t.val);
            if (t.left==null && t.right==null){
                return;
            }else if (t.left!=null && t.right==null){

                sb.append("(");
                preOrder(t.left, sb);
                sb.append(")");
            }else {

                sb.append("(");
                preOrder(t.left, sb);
                sb.append(")");

                sb.append("(");
                preOrder(t.right, sb);
                sb.append(")");
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root= TreeBuilt.buildTree2();
        String s=tree2str(root);
        System.out.println(s);
    }
}
