package Search;

import java.util.ArrayList;
import java.util.List;

public class KClosest {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        int l = 0;
        int r = arr.length-k;
        int mid = 0;
        while(l < r){
            mid = (l + r)/2;
            if (x - arr[mid] > arr[mid + k] - x) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        r = l+k;
        while(l < r){
            res.add(arr[l]);
            l++;
        }

        return res;
    }
}
