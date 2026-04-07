package CP.Contest.Round1091;

import java.io.*;
import java.util.StringTokenizer;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int t = Integer.parseInt(br.readLine().trim());

        while (t -- >0){
            StringTokenizer st= new StringTokenizer(br.readLine());

            int n= Integer.parseInt(st.nextToken());
            int m= Integer.parseInt(st.nextToken());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());


            String sloves = sloves(n, m, a, b);

            out.println(sloves);
            out.flush();


        }
    }

    private static String sloves(int n, int m, int a, int b) {
//        int visit[][]= new int[n][m];
//        dfsd(visit,n,m,a,b,-1,0,0);
//
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < m; j++) {
//
//                if (visit[i][j]!=1) return "NO";
//            }
//        }
//        return "YES";
        long g1 = gcd(n, a);
        long g2 = gcd(m, b);
        long g3 = gcd(n, m);

        if (g1 == 1 && g2 == 1 && g3 <= 2) return "YES";
        return "NO";
    }

    private static long gcd(long x, long y) {
        while (y != 0) {
            long temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }

    private static void dfsd(int[][] visit, int n, int m, int a, int b, int alter, int i, int j) {

        if (visit[i][j]==1){
            return;
        }

        visit[i][j]=1;
        int gr=((j+b-1)%m)+1;
        int gl=((i+a - 1)%n)+1;

        if (alter==-1){



            dfsd(visit,n,m,a,b,1, i,gr); // right
            dfsd(visit,n,m,a,b,0,gl,j); // down

        }

        if (alter==1){
            //go left
            dfsd(visit,n,m,a,b,0,gl,j);

        }
        else {
             // go right
            dfsd(visit,n,m,a,b,1, i,(((j+b-1)%m)+1));
        }
    }
}
