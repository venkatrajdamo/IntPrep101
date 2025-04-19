/*
Given a string s, rearrange the characters of s so that any two adjacent characters are not the same.
Return any possible rearrangement of s or return "" if not possible.

Example 1:
Input: s = "aab"
Output: "aba"

Example 2:
Input: s = "aaab"
Output: ""
*/

package String;

import java.util.*;

public class ReorganizeString {
    public String reorganizeString(String s) {
        HashMap<Character,Integer> m = new HashMap<>();
        int maxl = 0;
        Character maxC = ' ';
        for(Character c: s.toCharArray()){
            m.put(c, m.getOrDefault(c, 0) + 1);
            if(maxl< m.get(c)){
                maxl = m.get(c);
                maxC = c;
            }
        }

        if(maxl > (s.length() + 1)/2) return "";
        char[] r = new char[s.length()];
        m.remove(maxC);
        int i = 0;
        while(maxl != 0){
            r[i] = maxC;
            i += 2;
            maxl--;
        }

        for(Map.Entry<Character, Integer> e : m.entrySet()){
            int l = e.getValue();
            while (l!=0){
                if(i>=s.length()) i = 1;
                r[i] = e.getKey();
                i += 2;
                l--;
            }
        }

        return String.valueOf(r);
    }
}
