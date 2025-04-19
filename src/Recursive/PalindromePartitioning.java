package Recursive;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    List<List<String>> r = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(s, 0, new ArrayList<String>());
        return r;
    }

    public void dfs(String str, int s, ArrayList<String> p){
        if(s>=str.length()) r.add(new ArrayList<>(p));
        for (int i = s; i < str.length(); i++) {
            if(palindrome(str, s, i)){
                p.add(str.substring(s, i+1));
                dfs(str, i+1, p);
                p.removeLast();
            }
        }
    }

    public boolean palindrome(String str, int s, int e){
        while(s<e){
            if(str.charAt(s++) != str.charAt(e--))
                return false;
        }
        return true;
    }
}
