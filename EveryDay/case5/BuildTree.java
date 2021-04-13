package EveryDay.offer.TreeNode.case5;


public class BuildTree {
    public static TreeNode buildTree1() {
        // 先构造结点
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');
        TreeNode i = new TreeNode('I');
        TreeNode j = new TreeNode('J');
        //连接节点
        a.left = b;
        a.right = c;

        b.left = d;
        b.right = null;

        c.left = e;
        c.right = f;

        d.left = null;
        d.right = g;

        e.left = null;
        e.right = null;

        f.left = h;
        f.right = i;

        g.left = j;
        g.right = null;

        h.left = null;
        h.right = null;

        i.left = null;
        i.right = null;

        j.left = null;
        j.right = null;

        return a;
    }
    public static TreeNode buildTree2() {
        // 先构造结点
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode e = new TreeNode(15);
        TreeNode f = new TreeNode(7);

        a.left = b;
        a.right = c;

        b.left = null;
        b.right = null;

        c.left = e;
        c.right = f;

        return a;
    }
}

