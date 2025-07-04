package Arrays;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int min = 0;
        int max = 0;
        for(int n: nums) {
            max += n;
            min = Math.max(min, n);
        }
        int maxS = 0;
        int minS = 0;
        while (min <= max){
            maxS = min + (max - min) / 2;
            if(split(nums, maxS) <= k){
                max = maxS-1;
                minS = maxS;
            }
            else{
                min = maxS+1;
            }
        }
        return minS;
    }

    public int split (int[] nums, int max){
        int split = 0;
        int sum = 0;
        for (int n : nums){
            sum += n;
            if(sum > max){
                split++;
                sum = n;
            }
        }
        split++;
        return split;
    }
}
