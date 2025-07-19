package Heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> c = new HashMap<>();
        for(int n : nums){
            c.put(n, c.getOrDefault(n, 0)+1);
        }

        PriorityQueue<Integer> h = new PriorityQueue<>((a,b)->c.get(a) - c.get(b));

        for(int n : c.keySet()){
            h.offer(n);
            if(h.size() > k) h.poll();
        }
        int[] re = new int[k];
        for (int i = 0; i < k; i++) {
            re[i] = h.poll();
        }
        return re;
    }
}
