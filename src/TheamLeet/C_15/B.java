package TheamLeet.C_15;

import java.util.List;

public class B {
    public static void main(String[] args) {

        List<Integer> l= List.of(-15,-10,-2,3,-17,-1,13);

        System.out.println(maxIncreasingSubarrays(l));
        
    }
    public  static int maxIncreasingSubarrays(List<Integer> nums) {
        


        int l=0;
        int h= nums.size();

        int ans=1;
        while (l<=h){

            int mid= (l+h)/2;

            if (findWindow(nums,mid)){
                ans=mid;
                l=mid+1;
            }else {
                h=mid-1;
            }
        }
        return  ans;
        

    }

    private static boolean findWindow(List<Integer> nums, int mid) {
        int i = 0, j = 1;

        while (j < nums.size()) {
            if (nums.get(j) <= nums.get(j - 1)) i = j;

            if (j - i + 1 >= mid) {  // only fix needed
                int k = j + 1, l = j + 1;

                while (l < nums.size()) {
                    if (l > k && nums.get(l) <= nums.get(l - 1)) break;
                    if (l - k + 1 == mid) return true;
                    l++;
                }
            }
            j++;
        }
        return false;
    }


}
