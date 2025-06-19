package Arrays;

public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int cmax = nums[0];
        int cmin = nums[0];
        int pmax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int t = cmax;
            cmax = Math.max(nums[i], Math.max(nums[i] * cmax, nums[i] * cmin));
            cmin = Math.min(nums[i], Math.max(nums[i] * t, nums[i] * cmin));
            pmax = Math.max(pmax, cmax);
        }
        return pmax;
    }
}
