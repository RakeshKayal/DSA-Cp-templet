package CP.implementation;

import java.io.*;

public class SumofRoundNumbers {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {

            int n = Integer.parseInt(br.readLine().trim());
            String s = String.valueOf(n);

            StringBuilder sb = new StringBuilder();
            int c = 0;

            for (int i = 0; i < s.length(); i++) {

                int digit = s.charAt(i) - '0';

                if (digit == 0) continue;

                int zero = s.length() - i - 1;
                int value = digit * (int) Math.pow(10, zero);

                c++;
                sb.append(value).append(" ");
            }

            out.println(c);
            out.println(sb.toString().trim());
        }

        out.flush();
    }
}