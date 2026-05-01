package CodeForces.bs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Maximize {
    public static void main(String[] args) {

        int side = 2;
        int [][] points = {
                {2,1},
                {1,2},
                {2,0},
                {2,2},
                {0,0}
        };
        int k = 4;
        int i = maxDistance(side, points, k);
        System.out.println(i);

    }
    public static int maxDistance(int side, int[][] points, int k) {


        Arrays.sort(points, Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt(a -> a[1]));

        int n = points.length;
        int low = 1;
        int high = 2 * side;
        int ans = 0;


        while (low <= high) {
            int mid = (low + high) / 2;

            if (canSelect(points, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }


    private static boolean canSelect(int[][] points, int k, int minDist) {
        int count = 1;
        int[] last = points[0];
        int[] first = points[0];

        for (int i = 1; i < points.length; i++) {
            int dist = Math.abs(points[i][0] - last[0])
                    + Math.abs(points[i][1] - last[1]);

            if (dist >= minDist) {
                count++;
                last = points[i];
                if (count == k){

                    int wrapDist = Math.abs(last[0] - first[0])
                            + Math.abs(last[1] - first[1]);
                    return wrapDist >= minDist;
                    
                }
            }
        }
        return false;
    }
}
