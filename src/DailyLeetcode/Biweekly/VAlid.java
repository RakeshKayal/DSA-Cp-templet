package DailyLeetcode.Biweekly;

import java.util.HashMap;
import java.util.Map;

public class VAlid {
    public static void main(String[] args) {

        int n=5;
        int x=1;
        boolean b = validDigit(n, x);
        System.out.println(b);

    }
    public  static boolean validDigit(int n, int x) {

        Map<Integer,Integer> m= new HashMap<>();
        while (n>9){

            int res= n%10;
            m.put(res,m.getOrDefault(res,0)+1);
            n=n/10;
        }

        if (m.containsKey(x))return  true;
        return false;


    }
}
