package Graph;

public class RedundantConnection {
    private int[] size;
    private int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        this.size = new int[edges.length];
        this.parent = new int[edges.length];
        for (int node = 0; node < edges.length; node++) {
            size[node] = 1;
            parent[node] = node;
        }
        for(int[] e : edges){
            int n1 = e[0]-1;
            int n2 = e[1]-1;
            int r1 = find(n1);
            int r2 = find(n2);
            if (r1 == r2) return e;
            if(size[r1] > size[r2]) {
                parent[r2] = r1;
                size[r1] += size[r2];
            }
            else{
                parent[r1] = r2;
                size[r2] += size[r1];
            }
        }
        return new int[] {};
    }

    public int find(int n){
        if(this.parent[n] == n) return n;
        return parent[n] = find(parent[n]);
    }
}
