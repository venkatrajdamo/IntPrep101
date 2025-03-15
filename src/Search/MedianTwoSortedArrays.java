package Search;

public class MedianTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] a1;
        int[] a2;
        if(nums1.length <= nums2.length){
            a1 = nums1;
            a2 = nums2;
        }
        else{
            a1 = nums2;
            a2 = nums1;
        }

        int n1 = a1.length;
        int n2 = a2.length;
        int l = 0;
        int r = a1.length;
        int m1 = 0;
        int m2 =0;
        while (l<=r){
            m1 = (r+l)/2;
            m2 = (n1+n2+1)/2 - m1;
            int l1 = m1 == 0? Integer.MIN_VALUE : a1[m1-1];
            int r1 =  m1 == n1? Integer.MAX_VALUE : a1[m1];
            int l2 =  m2 == 0? Integer.MIN_VALUE : a2[m2-1];
            int r2 =  m2 == n2? Integer.MAX_VALUE : a2[m2];
            if(l1<=r2 && l2<=r1){
                if((n1+n2)%2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2))/2.0;
                }
                else{
                    return Math.max(l1,l2);
                }
            }
            if(l1 > r2) r = m1-1;
            else  l = m1+1;
        }
        return 0;
    }
}
