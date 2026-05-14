package CP.Bs;

import java.io.*;
import java.util.StringTokenizer;

public class PosinedDagger {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out= new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {

        int t=Integer.parseInt(br.readLine());
        while (t-- >0){

            StringTokenizer st= new StringTokenizer(br.readLine());

            int n=Integer.parseInt(st.nextToken());
            long h= Long.parseLong(st.nextToken());

            st= new StringTokenizer(br.readLine());


            long arr[]= new long[n];

            for( int i=0;i<n;i++){
                long a=Long.parseLong(st.nextToken());
                arr[i]=a;
            }


            long l=1;
            long r=h+1;

            long ans=0;

            while (l<=r){

                long mid = l + (r - l) / 2;


                if (canHit(mid,h,arr)){

                    ans=mid;
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }
            out.println(ans);
            out.flush();


        }
    }

    private static boolean canHit(long mid, long h, long[] arr) {


             long total=0;

             for(int i=0;i<arr.length-1;i++){

                 long cur= arr[i];
                 long increase=cur+mid-1;
                 if (increase>= arr[i+1]){
                     long r= arr[i+1]-1;
                     total+=r-cur+1;

                 }else {
                     total+=mid;
                 }

             }
             total+=mid;


             return  total>=h;


    }
}
