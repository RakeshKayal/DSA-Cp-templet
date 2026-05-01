package Array;

public class Fu {
    public static void main(String[] args) {

        String  s ="L_RL__R";
        System.out.println(furthestDistanceFromOrigin(s));

    }



    public static int furthestDistanceFromOrigin(String moves) {


        int n= moves.length();

        int left=0;
        int r=0;
        int d=0;

        for (int i = 0; i < n; i++) {

            if (moves.charAt(i)=='L'){
                left++;
            } else if (moves.charAt(i)=='R') {
                r++;
            }
            else {
                d++;
            }
        }

        if (r==left){
            return  d;
        } else if (r<left) {


            int ans= Math.abs(left-r);
            return  ans+d;
        }else{
            int ans= Math.abs(left-r);
            return  ans+d;

        }

    }
}
