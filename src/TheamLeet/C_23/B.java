package TheamLeet.C_23;

import java.util.*;

public class B {
    public static void main(String[] args) {

        int[] a={4,3,3,11,10,2,9,6};
        int k=4;
        int[] ints = mostCompetitive(a, k);
        for (int it: ints){
            System.out.print(it+" ");
        }


    }
    public static int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];



        Map<Integer, List<Integer>> m = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            m.computeIfAbsent(nums[i], a -> new ArrayList<>()).add(i);
        }

        int pre = -1;

        for (int i = 0; i < k; i++) {
            int stillNeed = k - i - 1;


            for (Map.Entry<Integer, List<Integer>> entry : m.entrySet()) {
                List<Integer> indices = entry.getValue();
                boolean picked = false;

                for (int j = 0; j < indices.size(); j++) {
                    int idx = indices.get(j);
                    if (idx <= pre) continue;

                    int remaining = n - idx - 1;
                    if (remaining >= stillNeed) {
                        ans[i] = entry.getKey();
                        pre = idx;
                        indices.remove(j);
                        if (indices.isEmpty()) m.remove(entry.getKey());
                        picked = true;
                        break;
                    }
                }
                if (picked) break;
            }
        }

        return ans;
    }
}
