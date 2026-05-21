package DailyLeetcode.Biweekly182;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class c {
    public static void main(String[] args) {
        int[][] p = {{0, 0, 0}, {5, 5, 5}};
        int[] t = {1, 1, 1};
        System.out.println(minGenerations(p, t));
    }

    public static int minGenerations(int[][] points, int[] target) {

        String targetKey = target[0] + "," + target[1] + "," + target[2];


        Set<String> current = new HashSet<>();
        for (int[] pt : points) {
            String key = pt[0] + "," + pt[1] + "," + pt[2];
            if (key.equals(targetKey)) return 0;
            current.add(key);
        }


        List<int[]> all = new ArrayList<>();
        for (int[] pt : points) all.add(pt);

        for (int k = 1; k <= points.length * 10; k++) {

            int size = all.size();
            List<int[]> newChildren = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                for (int j = i + 1; j < size; j++) {
                    int[] p1 = all.get(i);
                    int[] p2 = all.get(j);

                    int a = (int) Math.floor((p1[0] + p2[0]) / 2.0);
                    int b = (int) Math.floor((p1[1] + p2[1]) / 2.0);
                    int c = (int) Math.floor((p1[2] + p2[2]) / 2.0);

                    String key = a + "," + b + "," + c;

                    if (key.equals(targetKey)) return k;

                    if (!current.contains(key)) {
                        current.add(key);
                        newChildren.add(new int[]{a, b, c});
                    }
                }
            }

            if (newChildren.isEmpty()) break;  // no new points, stop early
            all.addAll(newChildren);
        }

        return -1;
    }
}