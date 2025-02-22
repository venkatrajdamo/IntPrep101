package Graph;

import java.util.PriorityQueue;

public class TeslaChargerMinStation {
    public int findFastestRoute(int[][] stations, int start, int target){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        int stops = 0, fuel = start, index = 0;

        while (fuel < target) {
            // Add all reachable stations to the max heap
            while (index < stations.length && stations[index][0] <= fuel) {
                maxHeap.offer(stations[index][1]); // Push available fuel at this station
                index++;
            }

            // If no station left and we still haven't reached the target
            if (maxHeap.isEmpty()) return -1;

            // Take the station with the maximum fuel
            fuel += maxHeap.poll();
            stops++; // Increase stop count
        }

        return stops;
    }
}
