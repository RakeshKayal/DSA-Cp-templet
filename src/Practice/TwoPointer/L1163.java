package Practice.TwoPointer;

import java.util.HashMap;
import java.util.Map;

public class L1163 {
    public static void main(String[] args) {
        String  s="cacacb";
        System.out.println(lastSubstring(s));

    }


    public static  String lastSubstring(String s) {


        int n=s.length();
        int ind=n-1;

        for (int i = n-2; i >=0 ; i--) {


            if (s.charAt(i)-'a' >s.charAt(i+1)-'a'){

                if (s.charAt(i)-'a'>=s.charAt(ind)-'a'){
                    ind=i;
                }

            }
        }

        return s.substring(ind);


    }
}
