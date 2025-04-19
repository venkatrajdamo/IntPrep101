package Recursive;

import java.util.*;

public class SubsetsII {
    List<List<Integer>> r = new ArrayList<>();
    int[] n;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        this.n = nums;
        Arrays.sort(this.n);
        subSets(0, new ArrayList<>());
        return r.stream().toList();
    }

    public void subSets(int ind, List<Integer> s){
        r.add(new ArrayList<>(s));
        for(int i = ind; i<n.length; i++){
            if(i != ind && n[i] == n[i-1]) continue;
            s.add(n[i]);
            subSets(i+1, s);
            s.removeLast();
        }
    }
}
