package Tree;

import java.util.HashMap;

public class PathSumIII {
    HashMap<Integer, Integer> m = new HashMap<>();
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        m.put(0, 1);
        sumPath(root, 0, targetSum);
        return count;
    }

    public void sumPath(TreeNode node, int sum, int k){
        if(node == null || sum >= Integer.MAX_VALUE) return;
        sum += node.val;
        if(m.containsKey(sum - k)){
            count += m.get(sum - k);
        }
        m.put(sum, m.getOrDefault(sum, 0) + 1);
        sumPath(node.left, sum, k);
        sumPath(node.right, sum, k);
        m.put(sum, m.get(sum) - 1);
    }

}
