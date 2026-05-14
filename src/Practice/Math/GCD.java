package Practice.Math;

public class GCD {
    public static void main(String[] args) {


        int a=5;
        int b=17;

        // naive approch

//        for (int i = Math.min(a,b); i >=1 ; i--) {
//
//            if (a%i==0 && b%i==0){
//                System.out.println(i);
//                return;
//            }
//        }


        while (a>0 &&b>0){

            if (a>b) a=a%b;
            else {
                b=b%a;
            }
        }
        if (a==0) System.out.println(b);
        else {
            System.out.println(a);
        }

        //O(log(math.min(a,b)))



    }
}
