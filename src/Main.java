import Arrays.MyArray;
import Dynamic.FewestCoin;
import Graph.TeslaCharger;
import LinkedList.MyLinkedList;
import LinkedList.SingleNode;

public class Main {
    public static void main(String[] args) {
        MyArray arr = new MyArray(new int [] {10, 5, 8, 15, 3, 5, 7, 5});
        System.out.println("Max : " + arr.getMax());
        System.out.println("Avg : " + arr.getAverage());
        System.out.println("5 occured " + arr.findNoOfOccurance(5) + " times");

        System.out.println("***************************************************");

        MyLinkedList list = new MyLinkedList();
        list.addToTail(5);
        list.addToTail(7);
        list.addToTail(1);
        list.addToTail(6);
        list.addToTail(4);


        System.out.println("Searching 6");
        SingleNode t = list.find(6);
        System.out.println("Found : " + t.value);
        list.reverse();
        System.out.println("***************************************************");

        FewestCoin few = new FewestCoin();
        int[]  coins = {1,2,5};
        few.findFewestCoin(coins, 11);

        System.out.println("***************************************************");
        TeslaCharger tesla = new TeslaCharger();
        int[][] stations = {
                {10, 5},   // Station at mile 10, swap time 5 mins
                {20, 8},   // Station at mile 20, swap time 8 mins
                {35, 3},   // Station at mile 35, swap time 3 mins
                {50, 6},   // Station at mile 50, swap time 6 mins
        };
        System.out.println("Minutes : " + tesla.findFastestRoute(stations, 30, 0, 50));
    }
}