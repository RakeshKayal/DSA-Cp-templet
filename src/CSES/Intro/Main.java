package CSES.Intro;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out= new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {


        //--------- :First :--------
       // long n= Integer.parseInt(br.readLine());
        //A(n);


        //--------- :Second :--------
//        int n = Integer.parseInt(br.readLine().trim());
//        long[] a = new long[n - 1];
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < a.length; i++) {  // < not <=
//            a[i] = Long.parseLong(st.nextToken());
//        }
//
//        B(a,n);

        //--------- :Third :--------
//
//        String s= br.readLine();
//        C(s);


        //--------- :Fourth :--------



    }

    private static void C(String s) {

        int i=0;
        int j=0;
        int c=0;

        while (j<s.length()){

            if (j>0 && s.charAt(j)!=s.charAt(j-1)){
                i=j;
            }
            c= Math.max(c,j-i+1);
            j++;
        }

        out.println(c);
        out.flush();
    }


    private static void B(long[] a, int n) {

        long sum=0;

        for (int i = 0; i < a.length; i++) {
            sum+=a[i];
        }

        long original = ((long) n * (n + 1)) / 2;
        out.println(original-sum);
        out.flush();
    }

    public static void A(long n){

        out.print(n);
        while (n!=1){

            if (n%2!=0){
                n=(n*3)+1;

            }else {
                n=n/2;

            }
            out.print(" " + n);
        }
        out.println();
       out.flush();


    }
}
