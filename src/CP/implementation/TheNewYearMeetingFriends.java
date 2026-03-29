package CP.implementation;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TheNewYearMeetingFriends {

    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out= new PrintWriter(new BufferedOutputStream(System.out));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int x1= Integer.parseInt(st.nextToken());
        int x2= Integer.parseInt(st.nextToken());
        int x3= Integer.parseInt(st.nextToken());


        int a[]= new int[3];
        a[0]=x1;
        a[1]=x2;
        a[2]=x3;
        Arrays.sort(a);


        int sum=0;
        sum=Math.abs(a[0]-a[1])+Math.abs(a[1]-a[2]);

        out.println(sum);

        out.flush();



    }
}
