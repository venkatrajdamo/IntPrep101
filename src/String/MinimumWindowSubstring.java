package String;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(int i =0; i<t.length(); i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) +1);
        }
        HashMap<Character, Integer> rMap = new HashMap<>();


        int i =0;
        int j = i;
        String str = "";
        int tl = 0;
        Integer min = Integer.MAX_VALUE;
        while(i<s.length()){
            Character sChar = s.charAt(i);
            if(tMap.containsKey(sChar))
            {
                while (i <=j && j< s.length()) {
                    Character eChar = s.charAt(j);
                    if(tMap.containsKey(eChar)) {
                        if (rMap.getOrDefault(eChar, 0) != tMap.get(eChar)) {
                            rMap.put(eChar, rMap.getOrDefault(eChar, 0) + 1);
                            tl++;
                        }
                        if(tl == t.length()){
                            rMap.put(sChar, rMap.get(sChar) - 1);
                            tl--;
                            if(j - i < min) {
                                min = Math.min(min, j - i);
                                str =  s.substring(i,j);
                            }
                            break;
                        }
                    }
                    j++;
                }
            }
            i++;
        }

        return str;
    }
}
