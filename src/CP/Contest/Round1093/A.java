package CP.Contest.Round1093;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class A {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            Set<Integer> s = Arrays.stream(a)
                    .boxed()
                    .collect(Collectors.toSet());

            if (n != s.size()) {
                out.println(-1);
            } else {
                Integer[] boxed = Arrays.stream(a).boxed().toArray(Integer[]::new);
                Arrays.sort(boxed, Collections.reverseOrder());

                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < boxed.length; i++) {
                    sb.append(boxed[i]);
                    if (i < boxed.length - 1) sb.append(" ");
                }
                out.println(sb);
            }



        }

        out.flush();
    }
}