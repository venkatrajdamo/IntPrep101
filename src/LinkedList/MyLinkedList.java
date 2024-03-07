package LinkedList;

public class MyLinkedList {
    SingleNode head;
    SingleNode tail;

    public SingleNode addToTail(int value){
        SingleNode temp =new SingleNode(value, null);
        if(this.head == null){
            this.head = temp;
            this.tail = temp;
        }
        else {
            this.tail.next = temp;
            this.tail = temp;
        }
        this.printList();
        return temp;
    }

    public void printList(){
        SingleNode c = this.head;
        System.out.print("List : ");
        while(c != null) {
            System.out.print(c.value + "|");
            c = c.next;
        }
        System.out.println();
    }
}
