package Arrays;

public class LongestIncreasingPathInMatrix {
    int[][] r;
    int[][] m;
    public int longestIncreasingPath(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        this.r = new int[rows][cols];
        this.m = matrix;

        // Initialize memo array with -1
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                r[i][j] = -1;
            }
        }

        int maxL = 0;
        // Use correct loop boundary for columns
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                maxL = Math.max(maxL, dfs(i, j, -1));
            }
        }
        return maxL;
    }

    private int dfs(int i, int j, int prev) {
        // Check boundaries and increasing condition
        if (i < 0 || i >= m.length || j < 0 || j >= m[0].length || m[i][j] <= prev)
            return 0;

        if (r[i][j] != -1)
            return r[i][j];

        int currentVal = m[i][j];
        int up = dfs(i - 1, j, currentVal);
        int down = dfs(i + 1, j, currentVal);
        int left = dfs(i, j - 1, currentVal);
        int right = dfs(i, j + 1, currentVal);

        int best = 1 + Math.max(Math.max(up, down), Math.max(left, right));
        r[i][j] = best;
        return best;
    }
}
