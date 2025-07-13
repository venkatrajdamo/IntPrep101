package Arrays;

public class TrappingRainWater {
    public int trap(int[] height) {
        int maxL = height[0];
        int maxR = height[height.length - 1];
        int l = 0;
        int r = height.length - 1;
        int sum = 0;
        while (l < r) {
            if(height[l] < height[r]){
                l++;
                if(height[l] < maxL){
                    sum += maxL - height[l];
                }
                maxL = Math.max(maxL,height[l]);
            }
            else {
                r--;
                if(height[r] < maxR){
                    sum += maxR - height[r];
                }
                maxR = Math.max(maxR,height[r]);
            }
        }
        return sum;
    }
}
