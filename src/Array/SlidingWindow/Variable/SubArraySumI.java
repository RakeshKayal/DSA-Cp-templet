package Array.SlidingWindow.Variable;

public class SubArraySumI {
    public static void main(String[] args) {

        int nums[]={1,2,3,4,3};

        int i=0;
        int j=0;
        int cnt=0;
        int sum=0;
        int tar=6;
        while(j<nums.length){
            sum+=nums[j];

            while (sum > tar) {
                sum -= nums[i];
                i++;
            }

            if (sum == tar) {
                cnt++;
            }

            j++;
        }
        System.out.println(cnt);
    }
}
