package Graph;

import java.util.HashSet;

public class NumberofIslands {
    char[][] g;
    public int numIslands(char[][] grid) {
        this.g = grid;
        int c = 0;
        for (int i = 0; i < grid.length; i++){
            for (int j =0; j < grid[0].length; j++){
                if(grid[i][j] == '1') {
                    getDfsSignature(i, j, i, j);
                    c++;
                }
            }
        }
        return c;
    }

    public void getDfsSignature(int sx, int sy, int i, int j){
        if(i < 0 || i >= g.length || j < 0 || j >= g[0].length) return;
        if(g[i][j] == '0') return;
        g[i][j] = '0';
        getDfsSignature(sx, sy, i+1, j);
        getDfsSignature(sx, sy, i-1, j);
        getDfsSignature(sx, sy, i, j+1);
        getDfsSignature(sx, sy, i, j-1);
    }
}
