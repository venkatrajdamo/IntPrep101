package Graph;

import java.util.*;

public class CourseSchedule {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] d = new int[numCourses];
        ArrayList<Integer> r = new ArrayList<>();
        Arrays.fill(d, 0);
        HashMap<Integer, LinkedList<Integer>> g = new HashMap<>();

        for(int i =0; i<numCourses; i++){
            g.put(i, new LinkedList<>());
        }

        for (int[] prerequisite : prerequisites) {
            g.get(prerequisite[1]).add(prerequisite[0]);
            d[prerequisite[0]]++;
        }


        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i<numCourses; i++){
            if(d[i] == 0){
                q.offer(i);
            }
        }

        int i = 0;
        while(!q.isEmpty()){
            Integer c = q.poll();
            r.add(c);
            for(Integer ch: g.get(c)){
                d[ch]--;
                if(d[ch] == 0) q.offer(ch);
            }
            i++;
        }
        return i == numCourses? r.stream()
                .mapToInt(Integer::intValue)
                .toArray() : new int[0];
    }
}
