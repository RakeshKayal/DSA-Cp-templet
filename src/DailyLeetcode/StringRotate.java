package DailyLeetcode;



public class StringRotate {
    public static void main(String[] args) {

       String  s = "abcde", goal = "abced";

        System.out.println(rotateString(s,goal));
    }
    public  static boolean rotateString(String s, String goal) {

        if(s.length()> goal.length() || s.length()<goal.length()) return false;
        if (s.equals(goal)) return  true;


        int n=s.length();
        for( int i=0;i<n-1;i++){
            String rotates = rotates(s,i+1);

            if(rotates.equals(goal)) return true;
        }
        return  false;
    }

    private static String  rotates(String s, int k) {

        char []c= s.toCharArray();

        int k1 = k % s.length();
        reverseArrays(c, 0, s.length() - 1);
        reverseArrays(c, 0, k1 - 1);
        reverseArrays(c, k1, s.length() - 1);
        return  new String(c);


    }

    private static void reverseArrays(char[] c, int i, int k) {
        while (i<k){
            char temp= c[i];
            c[i]= c[k];
            c[k]=temp;
            i++;
            k--;
        }
    }

}
