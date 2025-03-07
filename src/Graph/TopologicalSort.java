package Graph;

import java.util.*;

public class TopologicalSort {
    public boolean findPath(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        int[] in = new int[n];
        for (int i = 0; i < n; i++){
            in[i] = 0;
        }
        for(int i = 0; i < edges.length; i++){
            graph.putIfAbsent(edges[i][0], new ArrayList<>());
            graph.get(edges[i][0]).add(edges[i][1]);
            in[edges[i][1]]++;
        }
        Queue<Integer> S = new LinkedList<>();
        for (Integer node : graph.keySet()) {
            if (in[node] == 0) {
                S.offer(node);
            }
        }

        List<Integer> r = new ArrayList<>();
        while (!S.isEmpty()){
            Integer node = S.poll();
            r.add(node);
            for(Integer adj: graph.get(node)){
                in[adj]--;
                if (in[adj] == 0){
                    S.offer(adj);
                }
            }
        }
        if(r.size() != graph.size())
            return false;
        return true;
    }
}
