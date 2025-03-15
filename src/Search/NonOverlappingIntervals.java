package Search;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int prevEnd = intervals[0][1];
        for(int i = 1;  i< intervals.length ; i++){
            if(prevEnd > intervals[i][0]){
                count++;
            }
            else{
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}
