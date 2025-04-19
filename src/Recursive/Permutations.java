package Recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    int[] n;
    List<List<Integer>> r = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        this.n = nums;
        if(nums.length == 1)
            r.add(new ArrayList<>(Arrays.asList(nums[0])));
        else
            this.perm(0, new ArrayList<>());
        return r;
    }

    public void perm(int s, List<Integer> p){
        if(p.size() == this.n.length){
            r.add(new ArrayList<>(p));
            return;
        }

        for (int i = s; i < this.n.length; i++) {
            p.add(this.n[i]);
            this.swap(s, i);
            this.perm(s+1, p);
            p.removeLast();
            this.swap(i, s);
        }
    }

    public void swap(int a , int b){
        int t = this.n[a];
        this.n[a] = this.n[b];
        this.n[b] = t;
    }
}
