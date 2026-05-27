package TheamLeet.C_23;

public class A {
    public static void main(String[] args) {

        String  s="";
        System.out.println(minSwaps(s));

    }
    public static int minSwaps(String s) {

        int z=0;
        int n= s.length();
        if (n==0 || n==1) return -1;

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i)=='0') z++;
        }

        char maxEle='0';
        if (z>n-z){
            maxEle='0';
        }else {
            maxEle='1';
        }

        int max=Math.max(z,n-z);
        int min= Math.min(z,n-z);

        if (z==0 || z==n || (max!=min&& max-1!=min)) return -1;

        if (max!=min){

            int c=0;
            for (int i = 0; i < s.length(); i++) {

                if (i%2==0 && s.charAt(i)!=maxEle) c++;
            }
            return c;
        }

        int c_odd=0;
        int c_even=0;

        //odd z
        for (int i = 0; i < s.length(); i++) {

            if (i%2!=0 && s.charAt(i)!='0')c_odd++;

        }

        for (int i = 0; i < s.length(); i++) {
            if (i%2==0 && s.charAt(i)!='0')c_even++;
        }



        int m= Math.min(c_odd,c_even);

        return  m;



    }
}
