package CP.Contest.Round1089;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class simplesequence {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            if (n == 2) {
                out.println("2 1");
            } else {
                StringBuilder sb = new StringBuilder();
                sb.append(2);
                for (int i = n; i >= 3; i--) {
                    sb.append(" ").append(i);
                }
                sb.append(" 1");
                out.println(sb);
            }
        }
        out.flush();
    }
}