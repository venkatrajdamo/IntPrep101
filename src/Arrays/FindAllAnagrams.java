package Arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> re = new ArrayList<>();
        int pLen = p.length();
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> pMap = new HashMap<>();
        for (int i = 0; i < pLen; i++) {
            pMap.put(p.charAt(i), pMap.getOrDefault(p.charAt(i),0) + 1);
        }
        for (int i = 0; i < pLen && i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i),0) + 1);
        }
        if(sMap.equals(pMap))
            re.add(0);

        for (int i = pLen; i < s.length(); i++) {
            Character rc = s.charAt(i);
            sMap.put(rc, sMap.getOrDefault(rc, 0) + 1);

            Character lc = s.charAt(i - pLen);
            if(sMap.get(lc) == 1)
                sMap.remove(lc);
            else
                sMap.put(lc, sMap.get(lc) - 1);

            if(sMap.equals(pMap))
                re.add(i-pLen);
        }
        return re;
    }
}
