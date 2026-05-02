package CP.Bs;

import java.io.*;
import java.util.StringTokenizer;

public class Magic {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long k = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[n];
        long asum = 0;
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            asum += a[i];
        }

        st = new StringTokenizer(br.readLine());
        int[] b = new int[n];
        long bsum = 0;
        for (int i = 0; i < n; i++) {
            b[i] = Integer.parseInt(st.nextToken());
            bsum += b[i];
        }

        long l = 0;
        long r = (bsum + k) / asum;

        long ans = 0;
        while (l <= r) {
            long mid = (l + r + 1) / 2;

            if (canMake(mid, k, a, b)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        out.println(ans);
        out.flush();
    }

    private static boolean canMake(long mid, long k, int[] a, int[] b) {
        for (int j = 0; j < a.length; j++) {
            long need = (long) a[j] * mid - b[j];
            if (need > 0) {
                k -= need;
            }
            if (k < 0) return false;
        }
        return true;
    }
}