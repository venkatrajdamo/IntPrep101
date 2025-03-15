/*
Description:
You are given equations represented as pairs of variables, and the corresponding division results. Each equation is represented as A / B = k, where k is a floating-point number. Given a list of queries, you must determine the answers. If the answer cannot be determined, return -1.0.

Example 1:
Given equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].

Return: [6.0, 0.5, -1.0, 1.0, -1.0]
Explanation:
a/b = 2.0, b/c = 3.0
queries are: a/c, b/a, a/e, a/a, x/x

Example 2:

Input: equations = [["a","b"],["b","c"],["bc","cd"]],
values = [1.5,2.5,5.0],
queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]
*/

package Graph;

import java.util.*;

public class EvaluateDivision {
    Map<String, List<Pair<String, Double>>> graph = new HashMap<>();
    Map<String, Map<String, Double>> memo = new HashMap<>(); // Memoization cache

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        double[] res = new double[queries.size()];

        // Step 1: Build Graph (Adjacency List)
        for (int i = 0; i < equations.size(); i++) {
            String A = equations.get(i).get(0);
            String B = equations.get(i).get(1);
            double val = values[i];

            graph.putIfAbsent(A, new ArrayList<>());
            graph.putIfAbsent(B, new ArrayList<>());

            graph.get(A).add(new Pair<>(B, val));
            graph.get(B).add(new Pair<>(A, 1.0 / val));
        }

        // Step 2: Process Each Query Using BFS
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            res[i] = bfs(start, end);
        }

        return res;
    }

    private double bfs(String start, String end) {
        if (!graph.containsKey(start) || !graph.containsKey(end)) return -1.0;
        if (start.equals(end)) return 1.0;

        // If already computed, return from cache
        if (memo.containsKey(start) && memo.get(start).containsKey(end)) {
            return memo.get(start).get(end);
        }

        Queue<Pair<String, Double>> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(new Pair<>(start, 1.0));
        visited.add(start);

        while (!queue.isEmpty()) {
            Pair<String, Double> curr = queue.poll();
            String node = curr.getKey();
            double product = curr.getValue();

            if (node.equals(end)) {
                memo.putIfAbsent(start, new HashMap<>());
                memo.get(start).put(end, product);
                return product;
            }

            for (Pair<String, Double> neighbor : graph.get(node)) {
                if (!visited.contains(neighbor.getKey())) {
                    visited.add(neighbor.getKey());
                    queue.offer(new Pair<>(neighbor.getKey(), product * neighbor.getValue()));
                }
            }
        }
        return -1.0;
    }

    // Helper class for Pair
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
}
