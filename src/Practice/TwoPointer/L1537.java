package Practice.TwoPointer;

public class L1537 {
    public static void main(String[] args) {

    }
    public int maxSum(int[] nums1, int[] nums2) {


        // choose nus1 first..


        int n= nums1.length;
        int j=0;

        int s=0;
        for (int i = 0; i < n; i++) {

            s+=nums1[i];
            if (nums1[i]<nums2[j]){
                int k=i+1;  // may be the value present in num1 left

                boolean found=false;
                while (k<n){
                    s=s+nums1[k];
                    if (nums1[k]==nums2[j]){
                        found=true;
                        break;
                    }
                }

                if (found){

                    // 0 means nums1;
                    // 1 means nums2;
                }
            }else {
                j++;
            }

        }
        return  0;

    }
}
