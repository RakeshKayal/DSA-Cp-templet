package Array;

public class TicTacToe {
    public static void main(String[] args) {

        String  [] b={"O  ","   ","   "};

        boolean b1 = validTicTacToe(b);
        System.out.println(b1);


    }
    public static boolean validTicTacToe(String[] board) {

        if (board[0].charAt(0)=='O') return  false;
        int f=0;
        int s=0;
        int d=0;

        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (board[i].charAt(j)=='X') f++;
                else if (board[i].charAt(j)=='O')s++;
                else {
                    d++;

                }
            }
        }

        if (s>f) return  false;
        if (Math.abs(f-s)>=2) return  false;
        return  true;

    }
}
