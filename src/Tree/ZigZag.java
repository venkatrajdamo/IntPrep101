/*
Longest ZigZag Path in a Binary Tree
Problem Statement:
You are given the root of a binary tree.

A ZigZag path for a binary tree is defined as follows:
	•	Start at any node in the tree.
	•	Choose a direction: left or right.
	•	The next move must be in the opposite direction of the previous move.
	•	Continue this process as far as possible.

Return the length of the longest ZigZag path in the tree.

        1
       / \
      2   3
       \
        4
       /
      5

len = 3

*/
package Tree;

public class ZigZag {
    int maxZigZag = 0;
    public int longestZigZag(TreeNode root) {
        if (root == null) return 0;
        dfs(root.left, true, 1);  // Start left
        dfs(root.right, false, 1); // Start right
        return maxZigZag;
    }

    private void dfs(TreeNode node, boolean isLeft, int length) {
        if (node == null) return;

        maxZigZag = Math.max(maxZigZag, length);

        if (isLeft) {
            dfs(node.left, false, length + 1); // Go left → right
            dfs(node.right, true, 1); // Reset when same direction
        } else {
            dfs(node.right, true, length + 1); // Go right → left
            dfs(node.left, false, 1); // Reset when same direction
        }
    }
}
