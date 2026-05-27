package CP.Math;

import java.io.*;
import java.util.StringTokenizer;

public class ParkLight {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {

        int t= Integer.parseInt(br.readLine());

        while (t-->0){
            StringTokenizer st= new StringTokenizer(br.readLine());

            int n= Integer.parseInt(st.nextToken());
            int m= Integer.parseInt(st.nextToken());

            if (n==1 && m==1) {
                out.println(1);
            }else {
                int total_cell = n * m;

                int f= total_cell/2;
                int s= total_cell%2;

                out.println(f+s);
            }
            out.flush();
        }
    }
}
