package String;

import java.util.HashMap;

public class LongestSubstring {
    public int kSubstring(int k, String s){
        int sl = s.length();
        int l = 0;
        int max = 0;
        HashMap<Character, Integer> m = new HashMap<>();
        int i =0;
        int j =0;
        while(j < sl){
            Character c = s.charAt(j);
            if(m.containsKey(c)){
                m.put(c, m.get(c)+1);
            }
            else if(m.size() < k){
                m.put(c, 1);
            }
            else{
                while(m.size() >= k){
                    Character c1 = s.charAt(i);
                    if(m.get(c1) == 1)
                        m.remove(c1);
                    else
                        m.put(c1, m.get(c1)-1);
                    l--;
                    i++;
                }
                m.put(c, 1);
            }
            l++;
            j++;
            max = Math.max(max, l);
        }

        return max;
    }
}
