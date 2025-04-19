package Tree;

public class DiameterBinaryTree {
    int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return max;
    }
    public int diameter(TreeNode root) {
        if(root == null) return 0;
        int l = diameter(root.left);
        int r = diameter(root.right);
        max = Math.max(max, l + r);
        return Math.max(l,r) + 1;
    }
}
