package DailyLeetcode;

public class L3933 {
    public static void main(String[] args) {

    }
    public static int countLocalMaximums(int[][] matrix) {



        int n=matrix.length;
        int m= matrix[0].length;

        int c=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {


                if (matrix[i][j]!=0){

                    int x=matrix[i][j];
                    int up_row    = Math.max(0, i - x);
                    int down_row  = Math.min(n - 1, i + x);
                    int left_col  = Math.max(0, j - x);
                    int right_col = Math.min(m - 1, j + x);

                    boolean b = checkforMax(up_row, left_col, down_row, right_col, matrix[i][j],i,j,matrix);
                    if (b){
                        c++;
                    }

                }
            }
        }
        return c;

    }

    private static boolean checkforMax(int upRow, int leftCol, int downRow, int rightCol, int x, int i, int j, int[][] matrix) {

        for (int k = upRow; k <=downRow ; k++) {
            for (int l = leftCol; l <=rightCol ; l++) {

                if (Math.abs(k - i) == x && Math.abs(l - j) == x) continue;

                if (matrix[k][l]>x) return false;
            }
        }
        return  true;


    }
}
