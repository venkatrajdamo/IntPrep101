package Arrays;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestRangeCoveringKLists {
    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        int start = 0;
        int end = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            q.offer(new int[]{nums.get(i).getFirst(), i, 0 });
            max = Math.max(max, nums.get(i).getFirst());
        }


        while (!q.isEmpty()){
            int[] e = q.poll();
            int val = e[0];
            int lidx = e[1];
            int idx = e[2];
            if(max - val < end - start) {
                start = val;
                end = max;
            }
            if(idx + 1 < nums.get(lidx).size()) {
                idx++;
                int nexte = nums.get(lidx).get(idx);
                q.offer(new int[]{nexte, lidx, idx });
                max = Math.max(max, nexte);
            }
            else{
                break;
            }
        }
        return new int[]{start, end};
    }
}
