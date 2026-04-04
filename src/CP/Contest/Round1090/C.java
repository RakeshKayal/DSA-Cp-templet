package CP.Contest.Round1090;

import java.io.*;

public class C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int total = 3 * n;
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int waste = i + 1;
                int top1  = total - 2 * i;
                int top2  = total - 2 * i - 1;

                sb.append(waste).append(' ')
                        .append(top1).append(' ')
                        .append(top2).append(' ');
            }

            out.println(sb.toString().trim());
        }
        out.flush();
    }
}