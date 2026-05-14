package DailyLeetcode;

public class RotateBox {
    public static void main(String[] args) {

        char[][] bos={
                {'#','.','#'},
        };
        char[][] chars = rotateTheBox(bos);
        for (int i = 0; i <chars.length ; i++) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.print(chars[i][j]+" ");
            }
            System.out.println();
        }


    }
    public  static char[][] rotateTheBox(char[][] boxGrid) {

        int n=boxGrid.length;
        int m= boxGrid[0].length;


        char ans[][]= new char[m][n];


        for (int i = 0; i < n; i++) {

           doChange(boxGrid[i]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans[j][n - 1 - i] = boxGrid[i][j];
            }
        }
        return  ans;

    }

    private static void doChange(char[] chars) {
        int n = chars.length;
        int empty = n - 1;

        for (int i = n - 1; i >= 0; i--) {
            if (chars[i] == '*') {
                empty = i - 1;
            } else if (chars[i] == '#') {
                chars[i] = '.';
                chars[empty] = '#';
                empty--;
            }
        }
    }
}
