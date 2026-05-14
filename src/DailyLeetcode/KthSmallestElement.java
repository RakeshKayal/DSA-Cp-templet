package DailyLeetcode;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5, 7, 8, 10};
        int k = 6;

        int l = a[0];
        int h = a[a.length - 1];

        while (l < h) {
            int mid = (l + h) / 2;


            int count = countLessThanOrEqual(a, mid);

            if (count < k) {
                l = mid + 1;
            } else {
                h = mid;
            }
        }

        System.out.println(l);
    }

    static int countLessThanOrEqual(int[] a, int mid) {
        int count = 0;
        for (int x : a) {
            if (x <= mid) count++;
        }
        return count;
    }
}