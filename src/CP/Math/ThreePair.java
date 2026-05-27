package CP.Math;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class ThreePair {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {

        int t= Integer.parseInt(br.readLine());

        while (t-- > 0){

            StringTokenizer st= new StringTokenizer(br.readLine());

            int x=Integer.parseInt(st.nextToken());
            int y=Integer.parseInt(st.nextToken());
            int z= Integer.parseInt(st.nextToken());


            int a= Math.min(x,y);
            int b= Math.min(x,z);
            int c=Math.min(y,z);

            if (Math.max(a,b)==x && Math.max(a,c)==y && Math.max(b,c)==z){
                out.println("YES");
                out.println(a+" "+b+" "+c);
            }
            else {
                out.println("No");
            }
            out.flush();
        }
    }
}
