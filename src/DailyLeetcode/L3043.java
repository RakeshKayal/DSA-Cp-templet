package DailyLeetcode;

import java.util.HashSet;
import java.util.Set;

public class L3043 {
    public static void main(String[] args) {
        int a[]={1,10,2,100};
        int b[]={1000};

        System.out.println(longestCommonPrefix(a,b));

    }
    public static int longestCommonPrefix(int[] arr1, int[] arr2) {


//        int n=arr1.length;
//        int m= arr2.length;
//        int max=0;
//        for (int i = 0; i < n; i++) {
//            String s1= String.valueOf(arr1[i]);
//
//
//            for (int j = 0; j < m; j++) {
//
//
//                String s2= String.valueOf(arr2[j]);
//
//
//                int prefix = findPrefix(s1, s2);
//
//                max=Math.max(max,prefix);
//
//
//            }
//        }
//        return max;


        HashSet<Integer> prefixes = new HashSet<>();


        for (int num : arr1) {
            int x = num;
            while (x > 0) {
                prefixes.add(x);
                x /= 10;
            }
        }
        int ans=0;
        for (int n : arr2) {

            int x = n;
            int len =digits(x);
            while (x>0){
                if (prefixes.contains(x)){
                    ans=Math.max(ans,len);
                    break;
                }
                x=x/10;
                len--;
            }

        }
        return ans;
    }



    public static int digits(int x) {
        int cnt = 0;
        while(x > 0) {
            cnt++;
            x /= 10;
        }
        return cnt;
    }
}
