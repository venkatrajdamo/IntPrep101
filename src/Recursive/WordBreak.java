package Recursive;

import java.util.HashSet;
import java.util.List;

public class WordBreak {
    String str;
    HashSet<String> dict = new HashSet<>();
    Boolean[] memo;
    public boolean wordBreak(String s, List<String> wordDict) {
        str = s;
        dict.addAll(wordDict);
        memo = new Boolean[s.length()];
        return breakS(0);
    }

    public boolean breakS(int idx){
        if(idx == str.length()) return true;
        if(memo[idx] != null) return memo[idx];
        StringBuilder sb = new StringBuilder();
        int i = idx;
        while(i < str.length()){
            sb.append(str.charAt(i));
            if(dict.contains(sb.toString()) && breakS(i+1)){
                return memo[idx] = true;
            }
            i++;
        }
        return memo[idx] = false;
    }
}
