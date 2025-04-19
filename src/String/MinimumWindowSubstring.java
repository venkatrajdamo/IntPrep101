package String;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        for(int i =0; i<t.length(); i++){
            tMap.putIfAbsent(t.charAt(i), 0);
            tMap.put(t.charAt(i), tMap.get(t.charAt(i))+1);
        }
        HashMap<Character, Integer> rMap = new HashMap<>();


        int l =0;
        int r = 0;
        String str = "";
        int tl = 0;
        Integer min = Integer.MAX_VALUE;
        while(r<s.length()){
            Character sChar = s.charAt(r);
            rMap.putIfAbsent(sChar, 0);
            rMap.put(sChar, rMap.get(sChar)+1);
            if(tMap.containsKey(sChar) && rMap.get(sChar).intValue() == tMap.get(sChar).intValue())
                tl++;
            while(l<r && tl == tMap.size()){
                if(min > r - l + 1){
                    min = r - l + 1;
                    str = s.substring(l,r+1);
                }
                Character lChar = s.charAt(l);
                l++;
                rMap.put(lChar, rMap.get(lChar) - 1);
                if(tMap.containsKey(lChar) && rMap.get(lChar) < tMap.get(lChar)) {
                    tl--;
                }
            }
            r++;
        }

        return str;
    }
}
