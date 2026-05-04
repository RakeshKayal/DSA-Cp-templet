package CP.Bs;

import java.util.*;

public class pipe {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        long k = sc.nextLong();


        if (n == 1) {
            System.out.println(0);
            return;
        }


        long total = k * (k - 1) / 2;


        if (total < n - 1) {
            System.out.println(-1);
            return;
        }

        long l = 0, r = k ;
        long ans = k - 1;

        while (l <= r) {
            long mid = (l + r) / 2;
            long sum = mid * (2 * k - mid - 1) / 2;   // it just do calculate the largest 2(mid) value sum

            if (sum >= n - 1) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        System.out.println(ans);
    }
}