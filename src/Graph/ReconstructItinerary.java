package Graph;

import java.util.*;

public class ReconstructItinerary {
    HashMap<String, PriorityQueue<String>> m;
    LinkedList<String> result = new LinkedList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        m = new HashMap<>();
        for(List<String> t : tickets){
            m.putIfAbsent(t.get(0), new PriorityQueue<>());
            m.get(t.get(0)).offer(t.get(1));
        }
        dfs("JFK");
        return result;
    }

    public void dfs(String c){
        while(m.get(c) != null && !m.get(c).isEmpty()){
            String n = m.get(c).poll();
            dfs(n);
        }
        result.addFirst(c);
    }
}
