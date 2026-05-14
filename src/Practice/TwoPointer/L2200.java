    package Practice.TwoPointer;

    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;

    public class L2200 {
        public static void main(String[] args) {

           int [] nums = {2,2,2,2,2};
           int key = 2, k = 2;

            System.out.println(findKDistantIndices(nums,key,k));

        }
        public  static List<Integer> findKDistantIndices(int[] nums, int key, int k) {


            Map<Integer,List<Integer>> m= new HashMap<>();

            for (int i = 0; i < nums.length; i++) {

                if (nums[i]==key){
                    m.computeIfAbsent(nums[i],k1->new ArrayList<>()).add(i);
                }
            }

            List<Integer> list = m.get(key);
            List<Integer> ans= new ArrayList<>();

            for (int i = 0; i < nums.length; i++) {

                for(Integer it : list){
                    if (Math.abs(i-it)<=k){
                        ans.add(i);
                        break;
                    }   // it take O(n) the size of the List
                }






            }

            return  ans;

        }


    }
