package DailyLeetcode.Biweekly182;

public class B {
    public static void main(String[] args) {

        String  s="10101";
        System.out.println(minFlips(s));
    }

    public  static int minFlips(String s) {


        int n=s.length();


        int o=0;
        for (int i = 0; i < n; i++) {

            if (s.charAt(i)=='1'){
                o++;
            }
        }


        if (o==n) return 0;
        if (o==0) return 0;

        int ans=Integer.MAX_VALUE;

        ans= Math.min(ans, Math.abs(n-o));
        ans=Math.min(ans,Math.abs(o-1));


        if (n>1){
            int cost=0;
            int endone=0;
            if (s.charAt(0)=='1' && s.charAt(n-1)=='1')endone+=2;
            for (int i = 1; i <n-1 ; i++) {
                if (s.charAt(i)=='1'){
                    cost++;
                }
            }
            if (cost==0 && endone==2) return  0;
            else {
                ans=Math.min(ans,cost);
            }
        }
        return ans;



    }
}
