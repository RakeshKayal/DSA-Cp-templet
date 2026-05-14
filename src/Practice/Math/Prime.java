package Practice.Math;

public class Prime {
    public static void main(String[] args) {


        int n = 18;

//        int a= (int) Math.sqrt(n);
//        for (int i = 2; i <=a ; i++) {
//
//            if (n%i==0) {
//                System.out.println("false");
//                return;
//            }
//        }
//        System.out.println("true");


        // saive Algo

        int p[] = prime(n);
        for (int i = 1; i <= n; i++) {

            if (p[i] == 1) System.out.println(i);
        }


        //System.out.println(p[n]);


    }

    public static int[] prime(int n) {
        int[] p = new int[n + 1];

        for (int i = 2; i <= n; i++) p[i] = 1;

        for (int i = 2; i * i <= n; i++) {
            if (p[i] == 1) {
                for (int j = i * i; j <= n; j += i) {
                    p[j] = 0;
                }
            }
        }
        return p;  // p already has 1 for primes, 0 for composites
    }
}
