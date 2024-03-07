import Arrays.MyArray;
import LinkedList.MyLinkedList;

public class Main {
    public static void main(String[] args) {
        MyArray arr = new MyArray(new int [] {10, 5, 8, 15, 3});
        System.out.println("Max : " + arr.getMax());

        MyLinkedList list = new MyLinkedList();
        list.addToTail(5);
        list.addToTail(7);
        list.addToTail(1);
        list.addToTail(6);
        list.addToTail(4);
    }
}