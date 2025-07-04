package Arrays;

import java.util.HashMap;

public class SubarraySumEqualsKTrueFalse {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        m.put(0,-1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(k != 0)
                sum %= k;
            if(m.containsKey(sum)){
                if(i - m.get(sum) >= 2)
                    return true;
            }
            else {
                m.put(sum, i);
            }
        }
        return  false;
    }
}
