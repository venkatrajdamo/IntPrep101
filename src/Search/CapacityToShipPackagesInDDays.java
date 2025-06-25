/*
* Capacity to Ship Packages Within D Days

(LeetCode 1011 - Medium)

You are given an array weights of n items. Each weight represents the weight of a package.
You are also given an integer D, representing the number of days within which all the packages must be shipped.

You must ship the packages in order. You may not split a package.
Each day, you can carry packages up to a certain capacity.

Find the minimum ship capacity to ship all packages within D days.
*
Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
Output: 15
Explanation: Minimum capacity 15 allows shipping in 5 days.
*/

package Search;

public class CapacityToShipPackagesInDDays {
    int min = 0;
    int max = 0;
    public int shipWithinDays(int[] weights, int days) {
        for (int i = 0; i < weights.length; i++) {
            min = Math.max(min, weights[i]);
            max += weights[i];
        }

        int l = min;
        int r = max;
        int mid = 0;
        while (l < r){
            mid = (l + r)/2;
            if(ship(weights, days, mid)){
                r = mid;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }

    public boolean ship(int[] weights, int days, int c){
        int d  = 0;
        int shipped = 0;
        for (int i = 0; i < weights.length; i++) {
            if(shipped + weights[i] > c) {
                d++;
                shipped = 0;
            }
            shipped += weights[i];
            if(d == days)
                return false;
        }
        return true;
    }
}
