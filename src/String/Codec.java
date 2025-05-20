package String;

import java.util.ArrayList;
import java.util.List;

public class Codec {
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder s = new StringBuilder();
        for(String str : strs){
            s.append(str.length());
            s.append("#");
            s.append(str);
        }
        return s.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> r = new ArrayList<>();
        int i =0;
        int l = s.length();
        while(i < l){
            int j = s.indexOf('#', i);
            int sl = Integer.parseInt(s.substring(i, j));
            i= j+1;
            if(sl == 0){
                r.add("");
            }
            else {
                r.add(s.substring(i, i + sl));
                i = i+  sl;
            }
        }
        return  r;
    }
}
