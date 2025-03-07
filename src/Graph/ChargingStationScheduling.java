package Graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;

public class ChargingStationScheduling {
    static class Station {
        int rate;  // Charging rate (kWh/hr)
        int availableAt; // When the station becomes free

        Station(int rate, int availableAt) {
            this.rate = rate;
            this.availableAt = availableAt;
        }
    }

    public int maxChargedCars(int[][] requests, int[] chargingRates) {
        // Sort requests by arrival time
        Arrays.sort(requests, Comparator.comparingInt(a -> a[0]));

        // Min heap: Sort by availability time, then by charging rate (fastest first)
        PriorityQueue<Station> stations = new PriorityQueue<>(
                (a, b) -> a.availableAt != b.availableAt ? a.availableAt - b.availableAt : a.rate - b.rate
        );

        // Initialize charging stations
        for (int rate : chargingRates) {
            stations.offer(new Station(rate, 0));  // All stations are initially free at time 0
        }

        int count = 0;  // Count of cars fully charged

        for (int[] req : requests) {
            int arrival = req[0];
            int departure = req[1];
            int batteryNeeded = req[2];

            List<Station> temp = new ArrayList<>();

            while (!stations.isEmpty() && stations.peek().availableAt <= arrival) {
                temp.add(stations.poll());  // Collect all stations that are available at or before arrival
            }

            // Find the fastest available station
            Station bestStation = null;
            for (Station station : temp) {
                int finishTime = Math.max(arrival, station.availableAt) + (batteryNeeded + station.rate - 1) / station.rate;
                if (finishTime <= departure) {
                    bestStation = station;
                    bestStation.availableAt = finishTime;
                    count++;
                    break;
                }
            }

            // Put back all stations (used or unused) into the heap
            for (Station station : temp) {
                stations.offer(station);
            }

            if (bestStation != null) {
                stations.offer(bestStation);
            }
        }
        return count;
        }
}
