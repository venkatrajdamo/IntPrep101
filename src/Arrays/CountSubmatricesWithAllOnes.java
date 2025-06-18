package Arrays;

public class CountSubmatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        if(mat.length > 1){
            for (int i = 1; i < mat.length; i++) {
                for (int j = 0; j < c; j++) {
                    if(mat[i][j] == 1){
                        mat[i][j] = mat[i-1][j] + 1;
                    }
                }
            }
        }

        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < c; j++) {
                int min = mat[i][j];
                for (int k = j; k >= 0 && min > 0 ; k--) {
                    min = Math.min(min, mat[i][k]);
                    count += min;
                }
            }
        }
        return count;
    }
}
