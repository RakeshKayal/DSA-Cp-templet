package CP.Contest.Round1091;

import java.io.*;
import java.util.StringTokenizer;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int sum = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                sum += Integer.parseInt(st.nextToken());
            }

            // Shaunak wins if:
            // sum is odd (first player takes last move in standard game), OR
            // n*k is even (use special move, leave Yash with even total moves)
            boolean winsNormally = (sum % 2 == 1);
            boolean specialMoveWins = ((long)n * k % 2 == 0);

            if (winsNormally || specialMoveWins) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}