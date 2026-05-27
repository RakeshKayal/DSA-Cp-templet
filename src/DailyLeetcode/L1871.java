package DailyLeetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class L1871 {
    public static void main(String[] args) {

        String  s = "01001000";
        int minJump = 2, maxJump = 3;
        System.out.println(canReach(s,minJump,maxJump));
    }

    private static boolean canReach(String s, int minJump, int maxJump) {


        int n=s.length();

        int dp[]= new int[n];
        Arrays.fill(dp,-1);

        return  dfsCan(0,minJump,maxJump,n,s,dp);
    }

    private static boolean dfsCan(int node, int minJump, int maxJump, int n,String s, int[] dp) {

        if (dp[node] != -1) return dp[node] == 0;
        if (node == n - 1) return true;

        int left = node + minJump;
        int right = Math.min(node + maxJump, n - 1);

        for (int i = left; i <= right; i++) {
            if (s.charAt(i) == '0') {
                if (dfsCan(i, minJump, maxJump, n, s, dp)) {
                    dp[node] = 0;
                    return true;
                }
            }
        }

        dp[node] = 1;
        return false;



    }

    public static boolean canReach1(String s, int minJump, int maxJump) {


        Queue<Integer> q= new ArrayDeque<>();

        int visit[]= new int[s.length()];

        q.add(0);
        visit[0]=1;
        while (!q.isEmpty()){

                int idx=q.poll();

                if (idx== s.length()-1) return true;
                int left=idx+minJump;
                int right= Math.min(idx+maxJump,s.length()-1);
                 for (int i = left; i <=right ; i++) {
                         if (s.charAt(i)=='0' && visit[i]!=1){
                            q.add(i);
                            visit[i]=1;
                         }
                }
        }
        return  false;

    }
}
