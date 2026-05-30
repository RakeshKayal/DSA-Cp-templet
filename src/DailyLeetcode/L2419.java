package DailyLeetcode;

public class L2419 {
    public static void main(String[] args) {

        int a[]={1,2,3,4};
        System.out.println(longestSubarray(a));
    }
    public static int longestSubarray(int[] nums) {


        int max=0;
        int len=0;
        int st=0;

        for (int num: nums){

            if (num>max){
                max=num;
                len=0;
                st=0;
            }
            if (max==num){
                st++;
            }else {
                st=0;
            }
            len=Math.max(len,st);
        }
        return len;
    }
}
