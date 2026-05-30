package DailyLeetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class L3161 {
    public static void main(String[] args) {
        int[][] q = {
                {1, 2},
                {2, 3,3},
                {2,3,1},
                {2, 2,2},

        };
        System.out.println(getResults(q));
    }

    public static List<Boolean> getResults(int[][] queries) {
        List<Boolean> ans = new ArrayList<>();
        List<Integer> obstacle = new ArrayList<>();

        for (int[] it : queries) {
            int t = it[0];

            if (t == 1) {
                obstacle.add(it[1]);
            } else {
                Collections.sort(obstacle);

                int x = it[1];
                int sz = it[2];

                if (obstacle.isEmpty()) {
                    ans.add(x >= sz);
                    continue;
                }

                int xPosition = findXPosition(x, obstacle);
                boolean canPass = false;


                if (xPosition == 0) {
                    canPass = x >= sz;
                } else {

                    if (obstacle.get(0) >= sz) canPass = true;


                    if (!canPass) {
                        for (int i = 1; i < xPosition; i++) {
                            int gap = obstacle.get(i) - obstacle.get(i - 1);
                            if (gap >= sz) {
                                canPass = true;
                                break;
                            }
                        }
                    }


                    if (!canPass) {
                        int gap = x - obstacle.get(xPosition - 1);
                        if (gap >= sz) canPass = true;
                    }
                }

                ans.add(canPass);
            }

        }
        return ans;
    }

    private static int findXPosition(int x, List<Integer> obstacle) {
        int low = 0, high = obstacle.size();

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (obstacle.get(mid) <= x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}