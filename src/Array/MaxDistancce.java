package Array;

import java.util.HashMap;
import java.util.Map;

public class MaxDistancce {
    public static void main(String[] args) {

        int color[]={1,8,3,8,3};


        int i = maxDistance(color);
        System.out.println(i);

    }
    public  static int maxDistance1(int[] colors) {


        int n= colors.length;

        int max=Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            for (int j = i+1; j <n ; j++) {

                if (colors[i]!=colors[j]){
                    max=Math.max(max,Math.abs(i-j));
                }
            }
        }

        return  max;

        // make it optimal

    }
    public  static int maxDistance(int[] colors) {


        int n= colors.length;

        int max=Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            for (int j = i+1; j <n ; j++) {

                if (colors[i]!=colors[j]){
                    max=Math.max(max,Math.abs(i-j));
                }
            }
        }

        return  max;

        // make it optimal

    }
}
