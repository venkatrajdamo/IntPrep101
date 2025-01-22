/**
 * Problem: Binary Tree Level Order Traversal
 * Description:
 * Given the root of a binary tree, return its level order traversal as a list of lists. Each list represents the nodes at that level from left to right.
 *
 * Example:
 *
 * Input:
 *
 * markdown
 * Copy
 * Edit
 *     3
 *    / \
 *   9  20
 *      / \
 *     15  7
 * Output:
 *
 * csharp
 * Copy
 * Edit
 * [
 *   [3],
 *   [9, 20],
 *   [15, 7]
 * ]
 */


package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);
            }

            result.add(currentLevel);
        }

        return result;
    }
}
