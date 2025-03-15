package Graph;

public class WordSearch {
    public boolean search(char[][] board, String word){
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                if(dfs(board, board.length, board[0].length, i, j, word, 0))
                    return true;
            }
        return false;
    }

    private boolean dfs(char[][] a, int m, int n, int x, int y,  String word, int i){
        if(x<0 || x >= m || y<0 || y >= n){
            return false;
        }
        if(a[x][y] != word.charAt(i) || a[x][y] == '#') return false;

        if(i+1 == word.length()) return true;
        a[x][y] = '#';
        boolean r = (dfs(a, m, n, x-1, y, word, i + 1)
        || dfs(a, m, n, x+1, y, word, i + 1)
        || dfs(a, m, n, x, y-1, word, i + 1)
        || dfs(a, m, n, x, y+1, word, i + 1));
        a[x][y] = word.charAt(i);
        return r;
    }
}
