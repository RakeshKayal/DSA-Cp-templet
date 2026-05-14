package DailyLeetcode;

import java.util.ArrayList;
import java.util.List;

public class L2553 {
    public static void main(String[] args) {

        int n[]={200,12,30,23,43,10921,0};
        int[] ints = separateDigits(n);
        for (int i = 0; i < ints.length; i++) {
            System.out.print(ints[i]+",");
        }

    }




    public static int[] separateDigits1(int[] nums) {

        int n = nums.length;
        List<Integer> l = new ArrayList<>();


        for (int i = 0; i < n; i++) {

            int a = nums[i];

            if (a <= 9) {
                l.add(a);
            }

            String revn = revn(a);
            String o= String.valueOf(a);


            int revers=Integer.parseInt(revn);

            while (revers!=0){

                int r=revers%10;
                l.add(r);
                revers/=10;
            }

            if (o.length()!=revn.length()){
                int len=o.length()-revn.length();
                for (int j = 0; j < len; j++) {
                    l.add(0);
                }
            }
        }
        int ans[]= new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            ans[i]=l.get(i);
        }
        return ans;


    }


    private static String revn(int a) {


        int res=0;
        while (a!=0){
            int r= a%10;
            res=(10*res)+r;
            a/=10;
        }
        return new String(String.valueOf(res));
    }

    public static int[] separateDigits(int[] nums) {

        int n = nums.length;
        List<Integer> l = new ArrayList<>();


        for (int i = 0; i < n; i++) {

            int a= nums[i];

            if (a<=9){
                l.add(a);
            }else {

                String s= String.valueOf(a);

                for (int j = 0; j < s.length(); j++) {

                    int r= s.charAt(j)-'0';

                    l.add(r);
                }
            }


        }
        int ans[]= new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            ans[i]=l.get(i);
        }
        return ans;


    }
}
