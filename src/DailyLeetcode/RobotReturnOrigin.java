package DailyLeetcode;

import java.util.*;

public class RobotReturnOrigin {
    public static void main(String[] args) {
        String  moves="UD";

        boolean b = judgeCircle(moves);
        System.out.println(b);

    }

  
        public static boolean judgeCircle(String moves) {
            int horizontal = 0;
            int vertical = 0;

            for (int i = 0; i < moves.length(); i++) {
                char c = moves.charAt(i);

                if      (c == 'L') horizontal--;
                else if (c == 'R') horizontal++;
                else if (c == 'U') vertical++;
                else if (c == 'D') vertical--;
            }

            return horizontal == 0 && vertical == 0;
        }

}
