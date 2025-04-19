package Arrays;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int len = 0;
        int maxLen = 0;
        for(int n: nums){
            set.add(n);
        }
        int i =0;
        for (int num : set) {
            if(!set.contains(num - 1 )){
                int c = num + 1;
                len = 1;
                while(set.contains(c)){
                    len++;
                    c += 1;
                }
                maxLen = Math.max(maxLen, len);
            }
            i++;
        }
        return maxLen;
    }
}
