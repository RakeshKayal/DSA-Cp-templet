package CP.Math;

import java.io.*;

public class WaterMelon {

    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out= new PrintWriter(new BufferedOutputStream(System.out));
    public static void main(String[] args) throws IOException {

        int n= Integer.parseInt(br.readLine());


        if(n%2!=0) out.println("NO");
        else{

            if(n==2) out.println("NO");
            else {
                out.println("YES");
            }
        }



    }
}
