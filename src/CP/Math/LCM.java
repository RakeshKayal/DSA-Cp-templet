package CP.Math;

import java.util.Scanner;

public class LCM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            if (l * 2 > r) {
                System.out.println(-1 + " " + -1);
            } else {
                System.out.println(l + " " + (l * 2));
            }
        }
        sc.close();
    }
}