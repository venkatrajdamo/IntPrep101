/*
Problem Statement:

You are given a list of n car trips, where each trip is represented as [numPassengers, startLocation, endLocation].
The car starts empty and has a fixed capacity.

Determine if it is possible to complete all trips without exceeding capacity at any point.

Example:

Input:
trips = [[2,1,5],[3,3,7]]
capacity = 4

OP: false
*/
package Graph;

import java.util.TreeMap;

public class TeslaCarryPassengers {
    public boolean canCarryPassengers(int[][] trips, int capacity) {
        TreeMap<Integer, Integer> delta = new TreeMap<>();

        // Step 1: Record changes in passengers at each event (pickup/drop-off)
        for (int[] trip : trips) {
            delta.put(trip[0], delta.getOrDefault(trip[0], 0) + trip[2]); // Pickup
            delta.put(trip[1], delta.getOrDefault(trip[1], 0) - trip[2]); // Drop-off
        }

        // Step 2: Process events in order of stops
        int currentPassengers = 0;
        for (int change : delta.values()) {
            currentPassengers += change;
            if (currentPassengers > capacity) {
                return false; // Capacity exceeded
            }
        }

        return true; // Successfully processed all events
    }
}
