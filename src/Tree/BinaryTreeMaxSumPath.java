/*
Given a binary tree, find the maximum path sum.
A path is defined as any sequence of nodes from any node to any other node, where each node is connected via the parent-child relationship.
The path must contain at least one node, and it does not need to pass through the root.

Input: root = [1,2,3]
Output: 6
Explanation: The optimal path is 2 → 1 → 3 (sum = 6).
 */
package Tree;

public class BinaryTreeMaxSumPath {
    static int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        pathSum(root);
        return max;
    }

    public int pathSum(TreeNode root){
        if(root == null) return 0;
        int l = Math.max(pathSum(root.left), 0);
        int r = Math.max(pathSum(root.right), 0);
        int sum = Math.max(root.val +  l, root.val + r);
        //if(root.val < 0) return root.val;
        max = Math.max(max, root.val +  l + r);
        return sum;
    }
}
