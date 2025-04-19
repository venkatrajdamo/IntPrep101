package Recursive;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationsPhoneNumber {
    public List<String> letterCombinations(String digits) {
        HashMap<Character, String> m = new HashMap<>();
        m.put('2', "abc");
        m.put('3', "def");
        m.put('4', "ghi");
        m.put('5', "jkl");
        m.put('6', "mno");
        m.put('7', "pqrs");
        m.put('8', "tuv");
        m.put('9', "wxyz");
        
        List<String> r = new ArrayList<>();
        List<String> c = new ArrayList<>();
        for(Character ch : digits.toCharArray()){
            if(m.containsKey(ch))
                c.add(m.get(ch));
        }
        getLetters("", 0, c, r );
        return r;
    }
    
    public void getLetters(String s, int l, List<String> ns, List<String> r){
        if(ns.isEmpty()) return;
        if(l == ns.size() && !s.isEmpty()){
            r.add(s);
            return;
        }
        String ls = ns.get(l);
        for (Character c : ls.toCharArray()){
            getLetters(s + c, l +1, ns, r);
        }
    }
}
