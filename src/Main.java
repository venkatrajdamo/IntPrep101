import Arrays.MyArray;
import Dynamic.FewestCoin;
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

    }
}