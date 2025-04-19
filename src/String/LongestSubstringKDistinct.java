package String;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubstringKDistinct {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int l = 0;
        int r = 0;
        int max = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        if(k == 0) return 0;
        while(r < s.length()){
            m.putIfAbsent(s.charAt(r), 0);
            m.put(s.charAt(r), m.get(s.charAt(r))+1);
            while(m.size() > k){
                if(m.get(s.charAt(l)) == 1)
                    m.remove(s.charAt(l));
                else
                    m.put(s.charAt(l), m.get(s.charAt(l))-1);
                l++;
            }
            max = Math.max(max, r-l+1);
            r++;
        }
        return max;
    }
}
