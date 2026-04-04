package CP.Contest.Round1090;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class The67thntegerProblem {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        while (t-- >0){

            StringTokenizer st= new StringTokenizer(br.readLine());



            int a[]= new int[7];

            for (int i = 0; i < 7; i++) {
                a[i]= Integer.parseInt(st.nextToken());
            }


            Arrays.sort(a);

            int max= a[a.length-1];
            int sum=0;

            for (int i = 0; i <a.length-1 ; i++) {
                sum-=a[i];

            }
            sum+=max;

            out.println(sum);
            out.flush();
        }

    }
}