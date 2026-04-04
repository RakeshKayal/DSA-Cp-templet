package CP.Contest.Round1090;

import java.util.*;
import java.io.*;

public class D {

    static int[] sieve(int limit) {
        boolean[] isComposite = new boolean[limit + 1];
        isComposite[0] = isComposite[1] = true;
        for (int i = 2; (long)i * i <= limit; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j <= limit; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= limit; i++) {
            if (!isComposite[i]) primeList.add(i);
        }
        return primeList.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        int[] primes = sieve(200000);

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());

            for (int i = 0; i < n; i++) {
                if (i > 0) sb.append(' ');
                sb.append((long) primes[i] * primes[i + 1]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }
}