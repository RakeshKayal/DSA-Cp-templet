package DailyLeetcode.Weekly;

public class SumOfPrime {

    public static void main(String[] args) {

        int n= 10;
        System.out.println(sumOfPrimesInRange(n));

    }
    public static int sumOfPrimesInRange(int n) {

        int rev=revs(n);
        System.out.println(rev);


        if (n<rev) {
            int i = sumOfPrimesInRange1(n, rev);
            return  i;
        }
        else {
            int i = sumOfPrimesInRange1(rev, n);
            return i;
        }


    }

    private static int sumOfPrimesInRange1(int n, int rev) {

        int s=0;

        for (int i = n; i <=rev ; i++) {

            if (isPrime(i)){
                s+=i;
            }
        }
        return  s;
    }

    private static boolean isPrime(int i) {

        if (i <= 1) return false;
        if (i == 2) return true;


        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }

        return true;
    }
    private static int revs(int n) {

        int r=0;
        while (n!=0){

            int rem= n%10;

            r=(r*10)+rem;
            n/=10;
        }
        return  r;
    }
}
