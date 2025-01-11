/*
* Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
*Example 1:
*Input: n = 3
*Output: ["((()))","(()())","(())()","()(())","()()()"]
*/

package Recursive;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> r = new ArrayList<>();
        genarateLevels("", n, 0, 0, r);
        return r;
    }

    private void genarateLevels(String s, int n, int o, int c, List<String> r) {
        if (o + c == 2 * n) {
            r.add(s);
            return;
        }
        if (o < n) {
            genarateLevels(s + "(", n, o + 1, c, r);
        }
        if (c < o) {
            genarateLevels(s + ")", n, o, c + 1, r);
        }
        return;
    }
}
