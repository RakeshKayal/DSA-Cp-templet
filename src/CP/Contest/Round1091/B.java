package CP.Contest.Round1091;

import java.io.*;
import java.util.StringTokenizer;

public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out= new PrintWriter(new BufferedOutputStream(System.out));

        int t = Integer.parseInt(br.readLine().trim());

        while(t-- >0){

            StringTokenizer st= new StringTokenizer(br.readLine());

            int n= Integer.parseInt(st.nextToken());
            int k= Integer.parseInt(st.nextToken());

            int a[]= new int[n+1];
            st= new StringTokenizer(br.readLine());

            for (int i = 1; i <= n; i++) {
                a[i]=Integer.parseInt(st.nextToken());

            }
            int p= Integer.parseInt(br.readLine());

            int x= a[p];
            int ops=0;



            int prev = x;
            for (int i = p - 1; i >= 1; i--) {
                if (a[i] != prev) {
                    ops++;
                    prev = a[i];
                }
            }

// RIGHT side
            prev = x;
            for (int i = p + 1; i <= n; i++) {
                if (a[i] != prev) {
                    ops++;
                    prev = a[i];
                }
            }

            out.println(ops);


            out.flush();


        }

    }
}
