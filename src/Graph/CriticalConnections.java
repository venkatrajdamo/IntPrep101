package Graph;

import java.util.*;

public class CriticalConnections {
    private Map<Integer, List<Integer>> graph;
    private Map<Integer, Integer> rank;
    private Map<Pair<Integer, Integer>, Boolean> connDict;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {

        this.graph = new HashMap<Integer, List<Integer>>();
        this.rank = new HashMap<Integer, Integer>();
        this.connDict = new HashMap<Pair<Integer, Integer>, Boolean>();

        // Default rank for unvisited nodes is "null"
        for (int i = 0; i < n; i++) {
            this.graph.put(i, new ArrayList<Integer>());
            this.rank.put(i, null);
        }

        for (List<Integer> edge : connections) {

            // Bidirectional edges
            int u = edge.get(0), v = edge.get(1);
            this.graph.get(u).add(v);
            this.graph.get(v).add(u);

            int sortedU = Math.min(u, v), sortedV = Math.max(u, v);
            connDict.put(new Pair<Integer, Integer>(sortedU, sortedV), true);
        }

        this.dfs(0, 0, -1);

        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (Pair<Integer, Integer> criticalConnection : this.connDict.keySet()) {
            result.add(new ArrayList<Integer>(Arrays.asList(criticalConnection.getKey(), criticalConnection.getValue())));
        }

        return result;
    }

    private int dfs(int node, int discoveryRank, int parent) {
        if (rank.get(node) != null) {
            return rank.get(node);
        }

        rank.put(node, discoveryRank);
        int minRank = discoveryRank + 1; // Default minRank

        for (Integer neighbor : graph.get(node)) {
            if (neighbor == parent) continue; // Skip the parent node
            int recursiveRank = dfs(neighbor, discoveryRank + 1, node);

            if (recursiveRank <= discoveryRank) {
                connDict.remove(new Pair<>(Math.min(node, neighbor), Math.max(node, neighbor)));
            }

            minRank = Math.min(minRank, recursiveRank);
        }

        return minRank;
    }
}
class Pair<K, V> {
    private final K key;
    private final V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
    public K getKey() { return key; }
    public V getValue() { return value; }
}
