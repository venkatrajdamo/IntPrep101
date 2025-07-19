package Greedy;

import java.util.*;

public class TeslaCharger {
    public int findFastestRoute(int[][] stations, int batteryRange, int start, int end){
        HashMap<Integer, LinkedList<int[]>> graph = new HashMap<>();

        graph.put(0, new LinkedList<>());
        for (int[] station : stations) {
            if (batteryRange - station[0] >= 0) {
                graph.get(0).add(new int[]{station[0], station[1]});
            } else {
                break;
            }
        }
        for(int i = 0 ; i< stations.length; i++) {
            graph.put(stations[i][0], new LinkedList<>());
            for (int j = i + 1; j < stations.length; j++) {
                if (stations[j][0] - stations[i][0] <= batteryRange ) {
                    graph.get(stations[i][0]).add(new int[]{stations[j][0], stations[j][1]});
                }
                else{
                    break;
                }
            }
        }

        HashMap<Integer, Integer> dist = new HashMap<>();
        dist.put(0,0);
        for (int[] station : stations) {
            dist.put(station[0], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int d = current[1];

            if (node == end) return d;
            if (d > dist.get(node)) continue;

            for (int[] neighbor : graph.get(node)) {
                int neighborNode = neighbor[0];
                int edgeWeight = neighbor[1];
                int newDist = dist.get(node) + edgeWeight;

                if (newDist < dist.get(neighborNode)) {
                    dist.put(neighborNode,newDist);
                    pq.offer(new int[]{neighborNode, newDist});
                }
            }
        }
        return dist.get(end);
    }
}
