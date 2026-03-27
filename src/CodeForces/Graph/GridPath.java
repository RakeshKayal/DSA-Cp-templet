package CodeForces.Graph;

import java.util.Scanner;

public class GridPath {

    static int n, m, mod, k;

    static int add(int x, int y) {
        x += y;
        if (x >= mod) x -= mod;
        return x;
    }

    static long[][] auxArr;

    static int[][] mulMat(int[][] a, int[][] b) {
        int[][] b2 = new int[k][k];
        for (int x = 0; x < k; x++)
            for (int y = 0; y < k; y++)
                b2[x][y] = b[y][x];

        int[][] c = new int[k][k];
        for (int x = 0; x < k; x++) {
            for (int y = 0; y < k; y++) {
                auxArr[x][y] = 0;
                for (int z = 0; z < k; z++) {
                    auxArr[x][y] += (long) a[x][z] * b2[y][z];
                    if ((z & 7) == 7)   // every 8 steps to avoid overflow
                        auxArr[x][y] %= mod;
                }
                c[x][y] = (int) (auxArr[x][y] % mod);
            }
        }
        return c;
    }

    static int[][] binpow(int[][] a, int b) {
        int[][] c = new int[k][k];
        for (int i = 0; i < k; i++) c[i][i] = 1;

        while (b > 0) {
            if ((b & 1) == 1) c = mulMat(c, a);
            a = mulMat(a, a);
            b >>= 1;
        }
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        mod = sc.nextInt();

        k = 2 * m + 1;
        auxArr = new long[k][k];

        int[][] a = new int[k][k];
        a[k - 1][k - 1] = 1;

        for (int i = 0; i < m; i++) {
            for (int f = 0; f < 2; f++) {
                for (int l = (f != 0 ? 0 : i); l <= i; l++) {
                    for (int r = i; r < m; r++) {
                        a[i * 2 + f][k - 1] = add(a[i * 2 + f][k - 1], 1);
                        for (int j = l; j <= r; j++) {
                            a[i * 2 + f][j * 2 + (j == l ? 1 : 0)] =
                                    add(a[i * 2 + f][j * 2 + (j == l ? 1 : 0)], 1);
                        }
                    }
                }
            }
        }

        int[][] res = binpow(a, n);
        System.out.println(res[1][k - 1]);
    }
}