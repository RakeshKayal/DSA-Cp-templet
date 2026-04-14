package DailyLeetcode;

import java.util.*;

public class Mindist {
    public static void main(String[] args) {
       int[][]factory = {{2,2},{6,2}};

       List<Integer> robot= Arrays.asList(0,4,6);


        long l = minimumTotalDistance(robot, factory);
        System.out.println(l);

    }

    public  static long  minimumTotalDistance(List<Integer> robot, int[][] factory) {


        Collections.sort(robot);

        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        int n= robot.size();

        List<Integer> position= new ArrayList<>();

        for( int i[]:factory){
            int p=i[0];
            int l=i[1];

            for (int j = 0; j < l; j++) {

                position.add(p);
            }
        }
        int m= position.size();
        long[][] dp= new long[n+1][m+1];

        for(long[] row: dp){
            Arrays.fill(row,-1);
        }

        return  slover(0,0,robot,position,dp);




    }

    private static long slover(int i, int j, List<Integer> robot, List<Integer> position, long[][] dp) {


        if (i>=robot.size()) return 0;
        if (j>=position.size()) return (long) 1e8;

        if(dp[i][j]!=-1) return  dp[i][j];


        long take=Math.abs(robot.get(i)-position.get(j))+slover(i+1,j+1,robot,position, dp);

        long skip= slover(i,j+1,robot,position, dp);


        return dp[i][j]=Math.min(take,skip);

    }
}
