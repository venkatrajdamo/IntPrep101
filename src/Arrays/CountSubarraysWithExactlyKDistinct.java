package Arrays;

import java.util.HashMap;

public class CountSubarraysWithExactlyKDistinct {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return KDistinct(nums, k) - KDistinct(nums, k-1);
    }
    public int KDistinct(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<>();
        int l = 0;
        int r = 0;
        int count = 0;
        while(r < nums.length){
            int rv = nums[r];
            m.put(rv, m.getOrDefault(rv, 0)+1);
            if(m.get(rv) == 1) k--;

            while (k<0){
                int lv = nums[l];
                m.put(lv, m.get(lv) - 1);
                if(m.get(lv) == 0) k++;
                l++;
            }
            count += r -l + 1;
            r++;
        }
        return count;
    }
}
