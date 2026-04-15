package Array;

import java.util.Arrays;
import java.util.List;

public class Mountain {
    public static void main(String[] args) {
        List<Integer> mountain= Arrays.asList(1,2,3,4,5,3,2,1);

        int t=3;
        int min = findMin(mountain, t);
        System.out.println(min);
    }

    private static int findMin(List<Integer> mountain, int t) {


        int l = 0, r = mountain.size() - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (mountain.get(mid) > mountain.get(mid + 1)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int peak = r;


        int i = 0, leftEnd = peak;
        while (i <= leftEnd) {
            int mid = (i + leftEnd) / 2;
            if (mountain.get(mid) == t) {
                return mid;
            } else if (mountain.get(mid) < t) {
                i = mid + 1;
            } else {
                leftEnd = mid - 1;
            }
        }


        int j = peak + 1, k = mountain.size() - 1;
        while (j <= k) {
            int mid = (j + k) / 2;
            if (mountain.get(mid) == t) {
                return mid;
            } else if (mountain.get(mid) < t) {
                k = mid - 1;
            } else {
                j = mid + 1;
            }
        }

        return -1;
    }
}
