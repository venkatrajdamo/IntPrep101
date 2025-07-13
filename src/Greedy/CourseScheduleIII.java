package Greedy;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;

public class CourseScheduleIII {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, (a,b)->a[1] - b[1]);
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b)->b-a);
        int time = 0;
        for (int[] c : courses){
            if(time + c[0] <= c[1]){
                time += c[0];
                q.offer(c[0]);
            }
            else{
                if(!q.isEmpty() && q.peek() > c[0]){
                    time -= q.poll();
                    time += c[0];
                    q.offer(c[0]);
                }
            }
        }
        return q.size();
    }
}
