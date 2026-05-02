package CP.implementation;

import java.io.*;
import java.util.StringTokenizer;

public class SoldierandBananas {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out= new PrintWriter(new BufferedOutputStream(System.out));
    public static void main(String[] args) throws IOException {

        StringTokenizer st= new StringTokenizer(br.readLine());

        int k= Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(st.nextToken());
        int w=Integer.parseInt(st.nextToken());


        int sum= (w*(w+1))/2;

        int total=sum*k;


        if (n>total) out.println(0);
        else {
            out.println(total-n);
        }
        out.flush();

    }
}
