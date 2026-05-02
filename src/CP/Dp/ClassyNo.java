package CP.Dp;

import java.io.*;
import java.util.StringTokenizer;

public class ClassyNo {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out= new PrintWriter(new BufferedOutputStream(System.out));

    static  int ans;
    public static void main(String[] args) throws IOException {


        StringTokenizer st= new StringTokenizer(br.readLine());

        int t= Integer.parseInt(st.nextToken());

        while (t-- >0){

             st= new StringTokenizer(br.readLine());
            long l= Long.parseLong(st.nextToken());
            long r= Long.parseLong(st.nextToken());

            String  s1= String.valueOf(l);
            String  s2= String.valueOf(r);
      

            ans=0;

            countNo(0, s1, s2, true, true, true, 0);
            out.println(ans);
            out.flush();
        }
    }


    private static void countNo(int i, String s1, String s2,
                                boolean tightHigh, boolean tightLow,
                                boolean lz, int c) {
        if (i == s2.length()) {
            ans++;
            return;
        }
        if (c > 3) return;

        int lb = (tightLow && i < s1.length()) ? s1.charAt(i) - '0' : 0;
        boolean effectiveTightLow = tightLow && i < s1.length();

        int ub = tightHigh ? s2.charAt(i) - '0' : 9;

        for (int dig = lb; dig <= ub; dig++) {
            boolean nlz = lz && (dig == 0);
            boolean ntightHigh = tightHigh && (dig == ub);
            boolean ntightLow = effectiveTightLow && (dig == lb);
            countNo(i + 1, s1, s2, ntightHigh, ntightLow, nlz, (dig != 0 ? c + 1 : c));
        }
    }
}
