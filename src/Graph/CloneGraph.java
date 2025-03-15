package Graph;

import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}

public class CloneGraph {
    public Node cloneGraph(Node node) {
        HashMap<Integer, Node> c = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        if(node == null) return null;
        q.offer(node);

        while(!q.isEmpty()){
            Node o = q.poll();
            Node nn = c.getOrDefault(o.val, new Node(o.val));
            c.putIfAbsent(o.val, nn);
            for(Node child: o.neighbors){
                Node cn = c.getOrDefault(child.val, new Node(child.val));
                nn.neighbors.add(cn);
                c.putIfAbsent(child.val, cn);
                if(!c.containsKey(child.val)){
                    q.offer(child);
                }
            }
        }
        return  c.get(node.val);
    }
}
