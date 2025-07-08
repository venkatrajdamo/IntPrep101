package Dynamic;

public class MaximumLengthOfRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int d[][] = new int[nums1.length+1][nums2.length+1];
        int r = 0;
        for (int i = nums1.length - 1; i >=0 ; --i) {
            for (int j = nums2.length - 1; j >=0 ; --j) {
                if(nums1[i] == nums2[j]){
                    d[i][j] = d[i+1][j+1] + 1;
                    r = Math.max(r, d[i][j]);
                }
            }
        }
        return r;
    }
}
