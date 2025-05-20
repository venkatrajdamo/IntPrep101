package LinkedList;

import java.util.HashMap;

public class LRUCache {
    HashMap<Integer, ListNode> m = new HashMap();
    ListNode  h;
    ListNode t;
    int cap = 0;
    public LRUCache(int capacity) {
        this.h = new ListNode();
        this.t = new ListNode();
        this.h.next = t;
        this.t.prev = h;
        this.cap = capacity;
    }

    public int get(int key) {
        if(!this.m.containsKey(key)){
            return -1;
        }
        ListNode n = this.m.get(key);
        remove(n);
        add(n);
        return n.val;
    }

    public void put(int key, int value) {
        if(this.m.containsKey(key)){
            remove(this.m.get(key));
        }
        ListNode n = new ListNode();
        n.key = key;
        n.val = value;
        add(n);
        this.m.put(key, n);
        if(this.cap< this.m.size()) {
            n = this.t.prev;
            this.m.remove(n.key);
            remove(n);
        }
    }

    public void remove(ListNode n){
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    public void add(ListNode n){
        n.next = this.h.next;
        n.prev = this.h;
        this.h.next.prev = n;
        this.h.next = n;
    }
}
