/*
Tesla’s electric vehicles (EVs) travel long distances but require charging stops. Given a starting battery range, charging stations along the way, and a target destination, find the minimum number of charging stops required to reach the destination.

Each station provides a certain amount of charge. You can only charge at stations you pass and must optimize for the fewest stops.
Input:
	•	target: The destination in miles (integer).
	•	startBattery: The car’s initial charge range in miles (integer).
	•	stations[][]: A list of charging stations represented as [[position, charge]], where:
	•	position (int) → Distance from the starting point
	•	charge (int) → Additional miles of charge provided

Output:
	•	Integer → Minimum number of stops required.
	•	If it’s impossible to reach the target, return -1.

	int target = 100;
int startBattery = 10;
int[][] stations = {{10, 60}, {20, 30}, {30, 30}, {60, 40}};

minRechargeStops(target, startBattery, stations) // Output: 2
Explanation:
	•	Start with 10 miles of range.
	•	1st stop: Charge at station [10, 60] → Range becomes 70.
	•	2nd stop: Charge at [60, 40] → Range becomes 110 (enough to reach 100).
 */
package Graph;

import java.util.PriorityQueue;

public class MinRechargeStops {
    public int minRechargeStops(int target, int startBattery, int[][] stations) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // Max Heap
        int minStops = 0, battery = startBattery, index = 0, distanceCovered = 0;

        while (distanceCovered < target) {
            // Add all reachable stations into max heap
            while (index < stations.length && stations[index][0] <= distanceCovered + battery) {
                pq.offer(stations[index][1]); // Add fuel capacity
                index++;
            }

            // If we can't move forward & have no stations left to refuel
            if (pq.isEmpty()) return -1;

            // Refuel at the best (max fuel) station
            battery += pq.poll();
            minStops++;
            distanceCovered += battery;  // Move forward
        }
        return minStops;
    }
}
