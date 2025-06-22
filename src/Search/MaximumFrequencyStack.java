package Search;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MaximumFrequencyStack {
    Map<Integer, Integer> f;
    Map<Integer, Stack<Integer>> g;
    int maxFreq;
    public MaximumFrequencyStack() {
        f = new HashMap<>();
        g = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int freq = f.getOrDefault(val, 0 ) + 1;
        f.put(val, freq);
        maxFreq = Math.max(maxFreq, freq);
        g.putIfAbsent(maxFreq, new Stack<>());
        g.get(freq).push(val);
    }

    public int pop() {
        int v = g.get(maxFreq).pop();
        if(g.get(maxFreq).empty()) {
            g.remove(maxFreq);
            maxFreq--;
        }
        int freq = f.get(v);
        if(freq == 1) {
            f.remove(v);
        }
        else{
            freq--;
            f.put(v, freq);
        }
        return v;
    }
}
