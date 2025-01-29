/**
 *Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * The lowest common ancestor is defined as the lowest node in the tree that has both nodes as descendants (where we allow a node to be a descendant of itself).
 *
 * Example:
 * Input:
 * Binary tree:
 *
 * markdown
 * Copy code
 *         3
 *        / \
 *       5   1
 *      / \  / \
 *     6   2 0  8
 *        / \
 *       7   4
 * Nodes: 5 and 1
 *
 * Output:
 * 3
 *
 * Explanation:
 * The LCA of nodes 5 and 1 is 3, as 3 is the lowest node that has both as descendants.
*/


package Tree;

public class LowestCommonAncestor {
    public TreeNode commonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null)
            return null;
        if(root.val == p.val || root.val == q.val) return root;
        TreeNode l = commonAncestor(root.left, p, q);
        TreeNode r = commonAncestor(root.right, p, q);
        if(l == null && r == null)
            return null;
        if(l != null && r != null)
            return root;
        if(l == null)
            return r;
        else
            return l;
    }
}
