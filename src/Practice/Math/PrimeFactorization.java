package Practice.Math;

import java.util.ArrayList;
import java.util.List;

import static Practice.Math.Prime.prime;

public class PrimeFactorization {
    public static void main(String[] args) {

        int n = 17;
        List<Integer> ans = new ArrayList<>();

        for (int i = 2; i * i <= n; i++) {
            while (n % i == 0) {
                ans.add(i);
                n = n / i;
            }
        }

        if (n > 1) ans.add(n);
  //that every integer \(>1\) is either prime or a unique product of prime numbers.
        // If a number is divided by a prime factor, the quotient is either 1 or another
        // smaller integer, ensuring that only prime numbers are needed for a complete
        // factorization
        System.out.println(ans); // [2, 2, 3]
    }
}
