package CP.Math;

import java.io.*;
import java.util.StringTokenizer;

public class IchihimeTriangle {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());


            int x = b;
            int y = c;
            int z = c;


            out.println(x + " " + y + " " + z);


            out.flush();
        }
    }
}