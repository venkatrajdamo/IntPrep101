package Graph;

import java.util.*;

public class ShorteshPath {
    public int[] findPathint(int n, int[][] edges) {
        HashMap<Integer, LinkedList<int[]>> graph = new HashMap<>();
        HashSet<Integer> seen = new HashSet<>();
        LinkedList<Integer> q = new LinkedList<>();
        for(int[] edge : edges){
            if(!graph.containsKey(edge[0])){
                graph.put(edge[0], new LinkedList<>());
            }
            if(!graph.containsKey(edge[1])){
                graph.put(edge[1], new LinkedList<>());
            }
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int d = current[1];

            if (d > dist[node]) continue;

            for (int[] neighbor : graph.get(node)) {
                int neighborNode = neighbor[0];
                int edgeWeight = neighbor[1];
                int newDist = dist[node] + edgeWeight;

                if (newDist < dist[neighborNode]) {
                    dist[neighborNode] = newDist;
                    pq.offer(new int[]{neighborNode, newDist});
                }
            }
        }
        return dist;
    }
}
