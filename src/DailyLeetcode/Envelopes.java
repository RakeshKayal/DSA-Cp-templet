package DailyLeetcode;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Envelopes {
    public static void main(String[] args) {

        int [][] en={
                {5,4},
                {6,4},
                {6,7},
                {2,3}
        };
        System.out.println(maxEnvelopes(en));

    }
    public static int maxEnvelopes(int[][] envelopes) {


        Arrays.sort(envelopes, Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt(a -> -a[1]));



        int l=1;
        int r=envelopes.length;

        int ans=1;
        while (l<=r){

            int mid=l+(r-l)/2;

            if (canFit(mid,envelopes)){
                ans=mid;
                l=mid+1;
            }else {
                r=mid-1;
            }
        }

        return  ans;



    }

    private static boolean canFit(int mid, int[][] envelopes) {

        int total=1;
        int n=envelopes.length;
        int m= envelopes[0].length;

        int h=envelopes[n-1][1];
        int w=envelopes[n-1][0];

        for (int i = n-2; i >=0 ; i--) {


            int w1= envelopes[i][0];
            int h1=envelopes[i][1];

            if (h>h1 && w>w1){
                total++;
            }
        }
        return  total>=mid;


    }
}
