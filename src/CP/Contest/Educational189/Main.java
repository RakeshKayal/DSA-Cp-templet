package CP.Contest.Educational189;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out= new PrintWriter(new BufferedOutputStream(System.out));
    public static void main(String[] args) throws IOException {


        //A
        int t=Integer.parseInt(br.readLine());

//        while (t-- >0){
//            StringTokenizer st= new StringTokenizer(br.readLine());
//
//            long x= Long.parseLong(st.nextToken());
//            long y= Long.parseLong(st.nextToken());
//
//            long z= y-x;
//
//            if (z<=x) {
//                out.println("No");
//            }
//            else {
//                out.println("Yes");
//            }
//            out.flush();
//        }





        // B

        while (t-->0){

            String  s= br.readLine();


                Boolean finds = finds(s);

                if (finds){
                    out.println("YES");
                }
                else {
                    out.println("NO");
                }
                out.flush();
            }


    }

    private static boolean finds(String s) {
        return canFix(s, 'a') || canFix(s, 'b');
    }

    private static boolean canFix(String s, char startChar) {
        int first = -1, last = -1;

        for (int i = 0; i < s.length(); i++) {
            char expected = (i % 2 == 0) ? startChar : (char)('a' + 'b' - startChar);
            if (s.charAt(i) != expected) {
                if (first == -1) first = i;
                last = i;
            }
        }

        if (first == -1) return true;

        int blockLen = last - first + 1;


        for (int i = first; i <= last; i++) {
            char expected = (i % 2 == 0) ? startChar : (char)('a' + 'b' - startChar);
            if (s.charAt(i) == expected) return false; }

        int countA = 0;
        for (int i = first; i <= last; i++) {
            if (s.charAt(i) == 'a') countA++;
        }

        int expectedA = 0;
        for (int i = first; i <= last; i++) {
            char expected = (i % 2 == 0) ? startChar : (char)('a' + 'b' - startChar);
            if (expected == 'a') expectedA++;
        }
        int expectedB = blockLen - expectedA;

        if (countA == expectedA) return true;
        if (countA == expectedB) return true;

        return false;
    }
}
