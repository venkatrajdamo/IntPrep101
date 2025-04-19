/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

An island is considered to be the same as another if and only if one island can be translated (and not rotated or reflected) to equal the other.

Return the number of distinct islands.

Input: grid = [[1,1,0,0,0],[1,1,0,0,0],[0,0,0,1,1],[0,0,0,1,1]]
Output: 1
*/
package Graph;

import java.util.HashMap;
import java.util.HashSet;

public class NumberOfDistinctIslands {
    HashSet<String> m = new HashSet<>();
    int[][] g;
    public int numDistinctIslands(int[][] grid) {
        this.g = grid;
        for (int i = 0; i < grid.length; i++){
            for (int j =0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    this.m.add(getDfsSignature(i, j, i, j));
            }
        }
        return m.size();
    }

    public String getDfsSignature(int sx, int sy, int i, int j){
        if(i < 0 || i >= g.length || j < 0 || j >= g[0].length) return "";
        if(g[i][j] == 0) return "";
        g[i][j] = 0;
        String s = String.valueOf(sx - i) + String.valueOf(sy - j) +
                getDfsSignature(sx, sy, i+1, j) +
                getDfsSignature(sx, sy, i-1, j) +
                getDfsSignature(sx, sy, i, j+1) +
                getDfsSignature(sx, sy, i, j-1);
        return s;
    }
}
