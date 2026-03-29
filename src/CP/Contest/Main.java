package CP.Contest;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[] a = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                a[i] = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < n; i++) {
                int protected_val = a[i];

                List<Integer> arr = new ArrayList<>();
                for (int x : a) arr.add(x);

                boolean reduced = true;
                while (reduced && arr.size() >= 3) {
                    reduced = false;
                    for (int j = 0; j <= arr.size() - 3; j++) {
                        int x = arr.get(j), y = arr.get(j+1), z = arr.get(j+2);
                        int mn = Math.min(x, Math.min(y, z));
                        int mx = Math.max(x, Math.max(y, z));


                        if (mx != protected_val) {

                            if (arr.get(j) == mx) arr.remove(j);
                            else if (arr.get(j+1) == mx) arr.remove(j+1);
                            else arr.remove(j+2);
                            reduced = true;
                            break;
                        }

                        else if (mn != protected_val) {
                            if (arr.get(j) == mn) arr.remove(j);
                            else if (arr.get(j+1) == mn) arr.remove(j+1);
                            else arr.remove(j+2);
                            reduced = true;
                            break;
                        }
                    }
                }

                sb.append(arr.size());
                if (i < n - 1) sb.append(" ");
            }

            out.println(sb);
            out.flush();
        }
    }
}