package Search;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {
    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public FindMedianFromDataStream() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b) -> (b - a));
    }

    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        if(min.size() > max.size())
            max.offer(min.poll());
    }

    public double findMedian() {
        if(max.isEmpty()) return 0;
        if(min.size() == max.size())
            return (min.peek() + max.peek())/2.0;
        return max.peek();
    }
}
