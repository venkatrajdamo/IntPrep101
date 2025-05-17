package Tree;

import java.util.*;

public class MinimumHeightTrees {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

        // edge cases
        if (n < 2) {
            ArrayList<Integer> centroids = new ArrayList<>();
            for (int i = 0; i < n; i++)
                centroids.add(i);
            return centroids;
        }

        HashMap<Integer,Set<Integer>> neighbors = new HashMap<>();
        for (int i = 0; i < n; i++)
            neighbors.put(i, new HashSet<Integer>());

        for (int[] edge : edges) {
            Integer start = edge[0], end = edge[1];
            neighbors.get(start).add(end);
            neighbors.get(end).add(start);
        }

        int remNode = n;
        ArrayList<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++)
            if (neighbors.get(i).size() == 1)
                leaves.add(i);

        while (remNode > 2){
            remNode -= leaves.size();
            ArrayList<Integer> newLeaves = new ArrayList<>();
            for (Integer node: leaves){
                int c = neighbors.get(node).iterator().next();
                neighbors.get(c).remove(node);
                if (neighbors.get(c).size() == 1){
                    newLeaves.add(c);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
