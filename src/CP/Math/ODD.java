package CP.Math;

import java.io.*;
import java.util.StringTokenizer;

public class ODD {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int t=Integer.parseInt(br.readLine());

        while (t-- >0){
            int n=Integer.parseInt(br.readLine());



            boolean o=false;
            boolean e=false;
            int[] a=new int[n];
            StringTokenizer st= new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {

               a[i]=Integer.parseInt(st.nextToken());

            }
            int sum=0;
            for (int i = 0; i < n; i++) {


                sum+=a[i];
                if(a[i]%2!=0){
                    o=true;
                }
                if (a[i]%2==0) e=true;

            }


            if (sum % 2 != 0 || (o&& e))out.println("YES");
            else {
                out.println("NO");
            }

                out.flush();

        }
    }
}
