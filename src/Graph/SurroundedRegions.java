package Graph;

public class SurroundedRegions {
    char[][] g;
    public void solve(char[][] board) {
        this.g = board;
        int rLen = board.length;
        int cLen = board[0].length;
        for (int i = 0; i < rLen; i++){
            if(g[i][0] == 'O') {
                Dfs(i, 0);
            }
            if(g[i][cLen-1] == 'O') {
                Dfs(i, cLen-1);
            }
        }
        for (int j =0; j < cLen; j++){
            if(g[0][j] == 'O') {
                Dfs(0, j);
            }
            if(g[rLen-1][j] == 'O') {
                Dfs(rLen-1, j);
            }
        }

        this.replace('O', 'X');
        this.replace('1', 'O');
        board = this.g;
    }

    public void Dfs(int i, int j){
        if(i < 0 || i >= g.length || j < 0 || j >= g[0].length) return ;
        if(g[i][j] == 'X' || g[i][j] == '1') return;
        g[i][j] = '1';
        Dfs(i+1, j);
        Dfs(i-1, j);
        Dfs(i, j+1);
        Dfs(i, j-1);
    }

    public void replace(Character o, Character n){
        for (int i = 0; i < g.length; i++){
            for (int j =0; j < g[0].length; j++){
                if(g[i][j] == o) {
                    this.g[i][j] = n;
                }
            }
        }
    }
}
