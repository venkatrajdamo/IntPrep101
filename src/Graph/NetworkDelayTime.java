package Graph;

import java.util.*;

public class NetworkDelayTime {
    public int networkDelayTime(int[][] times, int n, int k) {
        HashMap<Integer, List<Pair>> g = new HashMap<>();

        for(int[] t : times) {
            g.putIfAbsent(t[0], new ArrayList<>());
            g.get(t[0]).add(new Pair<>(t[1], t[2]));
        }

        PriorityQueue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(Pair<Integer, Integer>::getValue));
        HashMap<Integer, Integer> d = new HashMap<>();
        q.offer(new Pair(k, 0));
        d.putIfAbsent(k, 0);
        int maxd = 0;
        while(!q.isEmpty()){
            Pair<Integer, Integer> p = q.poll();
            int dist = p.getValue();
            if(dist > d.getOrDefault(p.getKey(), Integer.MAX_VALUE)) continue;
            d.put(p.getKey(), dist);
            maxd = Math.max(maxd, dist);
            for (Pair<Integer, Integer> c : g.getOrDefault(p.getKey(), new ArrayList<>())){
                int cd = c.getValue() + dist;
                if(!d.containsKey(c.getKey())){
                    q.offer(new Pair<>(c.getKey(),cd));
                }
            }
        }

        return d.size() == n? maxd : -1;
    }
}
