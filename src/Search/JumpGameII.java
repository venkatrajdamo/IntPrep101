package Search;

public class JumpGameII {
    public int jump(int[] nums) {
        int end = 0;
        int far = 0;
        int i = 0;
        int r = 0;
        while(i < nums.length-1){
            far = Math.max(far, i + nums[i]);
            if(i == end){
                r++;
                end = far;
            }
            i++;
        }
        return r;
    }
}
