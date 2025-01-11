/**
 * You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.
 *
 * Return the number of connected components in the graph.
 * Input: n = 5, edges = [[0,1],[1,2],[3,4]]
 * Output: 2
 * */
package Graph;

import java.util.*;

public class ConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, LinkedList<Integer>> graph = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();
        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 0; i < edges.length; i++){
            if(!graph.containsKey(edges[i][0])){
                graph.put(edges[i][0], new LinkedList<>());
            }
            if(!graph.containsKey(edges[i][1])){
                graph.put(edges[i][1], new LinkedList<>());
            }
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }

        int comp = 0;
        for(int i = 0; i < n; i++) {
            if(seen.contains(i)){
                continue;
            }
            else{
                q.add(i);
                comp++;
            }
            while (!q.isEmpty()) {
                Integer node = q.removeFirst();
                seen.add(node);
                if(graph.containsKey(node)){
                    q.addAll(graph.get(node));
                    graph.remove(node);
                }
            }
        }
        return comp;
    }
}
