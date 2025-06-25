package Arrays;

public class FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int i = 0;
        int d = -1;
        while(i < nums.length){
            int c = Math.abs(nums[i]);
            if(nums[c] < 0){
                d = c;
                break;
            }
            nums[c] *= -1;
            i++;
        }

        for (int j = 0; j < nums.length; j++) {
            nums[j] = Math.abs(nums[j]);
        }

        return d;
    }
}
