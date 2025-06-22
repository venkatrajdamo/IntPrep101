package Arrays;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        StringBuilder r = new StringBuilder();
        Stack<Character> s = new Stack<>();
        for(Character c : num.toCharArray()){
            while(!s.empty() && s.peek() > c && k > 0){
                s.pop();
                k--;
            }
            s.push(c);
        }
        while (k > 0){
            s.pop();
            k--;
        }

        for(Character d : s){
            if(r.isEmpty() && d == '0') continue;
            r.append(d);
        }
        return r.isEmpty() ? "0" : r.toString();
    }
}
