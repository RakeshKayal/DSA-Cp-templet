package DailyLeetcode.Biweekly;

public class Botinic {
    public static void main(String[] args) {

        int nu[]={1,3,2,1};

        int i = compareBitonicSums(nu);
        System.out.println(i);

    }
    public  static int compareBitonicSums(int[] nums) {


        int peek=binary(nums);

        int s1=0;
        for( int i=0;i<=peek;i++){
            s1+=nums[i];
        }
        int s2=0;
        for (int i = peek; i <nums.length ; i++) {
            s2+=nums[i];
        }

        if (s1>s2)return  0;
        if (s1<s2) return 1;

        return -1;

    }

    private static int binary(int[] nums) {
        int l=0;
        int r=nums.length-1;
        int ans=0;
        while (l<r){
            int mid= (l+r)/2;

            if (nums[mid]<nums[mid+1]) {
                r = mid;
                ans=mid;
            }else {
                l=mid+1;
            }
        }
        return  ans;
    }
}
