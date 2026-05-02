package CP.Math;

import java.io.*;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Floor {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out= new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {


        int t=Integer.parseInt(br.readLine());
        while (t-- >0){
            StringTokenizer st= new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int x=Integer.parseInt(st.nextToken());

            if (n<=2){
                out.println(1);
            }else {
                int ans=(n-3)/x;
                out.println(ans+2);
            }
            out.flush();
        }

    }
}
