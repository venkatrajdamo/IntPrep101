package LinkedList;

class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

public class ReorderList {
    ListNode ro = null;
    public void reorderList(ListNode head) {
        this.ro = head;
        ListNode s = head;
        ListNode f = head;
        if(head == null || head.next == null) return;
        while(s !=null && s.next != null && f != null){
            s = s.next;
            if(f.next != null)
                f = f.next.next;
            else
                f = null;
        }
        reorder(s).next = null;
    }

    public ListNode reorder(ListNode r){
        ListNode l1;
        if(r == null) return this.ro;
        l1 = reorder(r.next);
        ListNode t = l1.next;
        r.next = l1.next;
        l1.next = r;
        return t;
    }
}
