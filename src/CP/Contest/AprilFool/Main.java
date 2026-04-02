package CP.Contest.AprilFool;

import java.io.*;
import java.util.StringTokenizer;


//and?
public class Main {

    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out= new PrintWriter(new BufferedOutputStream(System.out));
    public static void main(String[] args) throws IOException {


        int t= Integer.parseInt(br.readLine());

        while (t-->0) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int c = Integer.parseInt(st.nextToken());


            long s= a+b+c;

            long ans= (int) (s/3)+(s%3);

            out.println(ans);
            out.println("Output a number.");
            out.flush();


        }



    }
}
