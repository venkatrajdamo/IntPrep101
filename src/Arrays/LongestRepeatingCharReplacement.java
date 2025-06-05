package Arrays;

import java.util.HashMap;

public class LongestRepeatingCharReplacement {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> m = new HashMap<>();
        int re = 0;
        int l = 0;
        int r = 0;
        int max = 0;
        while (r < s.length()){
            Character c = s.charAt(r);
            m.put(c, m.getOrDefault(c, 0)+1);
            max = Math.max(max, m.get(c));
            if (r+1-l-max > k){
                m.put(s.charAt(l), m.get(s.charAt(l))- 1);
                l++;
            }
            re = r+1-l;
            r++;
        }
        return  re;
    }
}
