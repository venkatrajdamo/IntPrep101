package Greedy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)-> b-a);
        HashMap<Character, Integer> fre = new HashMap<>();
        for(char c : tasks) {
            fre.put(c, fre.getOrDefault(c, 0) + 1);
        }
        fre.values().forEach(q::offer);

        int count=0;
        while (!q.isEmpty()){
            int gap = 0;
            List<Integer> l = new ArrayList<>();
            while (gap <= n && !q.isEmpty()){
                int freq = q.poll();
                freq--;
                gap++;
                if(freq > 0) l.add(freq);
            }
            l.forEach(q::offer);
            count += q.isEmpty() ? gap : n+1;
        }

        return count;
    }
}
