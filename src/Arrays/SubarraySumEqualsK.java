package Arrays;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int count = 0;
        int sum = 0;
        m.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(m.containsKey(sum - k)){
                count += m.get(sum - k);
            }
            m.put(sum, m.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}
