package String;

import java.util.HashSet;

public class LongestSubstringWithoutRepeating {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int l = 0;
        int r = 0;
        int max = 0;
        while(r < s.length()){
            if(set.contains(s.charAt(r))){
                while(s.charAt(l) != s.charAt(r)){
                    set.remove(s.charAt(l));
                    l++;
                }
                l++;
            }
            set.add(s.charAt(r));
            max = Math.max(max, set.size());
            r++;
        }
        return max;
    }
}
