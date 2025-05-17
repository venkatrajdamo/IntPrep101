package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> r = new ArrayList<>();
        int i = 0;
        while(i < intervals.length && intervals[i][1] < newInterval[0]){
            r.add(new int[] {intervals[i][0], intervals[i][1]});
            i++;
        }

        while(i < intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        r.add(new int[] {newInterval[0], newInterval[1]});

        while(i < intervals.length){
            r.add(new int[] {intervals[i][0], intervals[i][1]});
            i++;
        }
        return r.toArray(new int[r.size()][]);
    }
}
