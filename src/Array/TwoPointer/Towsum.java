package Array.TwoPointer;

import java.util.Arrays;

public class Towsum {
    public static void main(String[] args) {
        int a[]={2,3,5,6,8};  // find and return the index

        int s=9; //sum=9;

        Arrays.sort(a);

        int[] solves = solves(a, s);
        System.out.println(solves[0]+ " :" +solves[1]);



    }

    private static int[] solves(int[] a, int s) {



        int i=0;
        int j= a.length-1;


        while (i<=j){
            if (a[i]+a[j]==s) return  new int[]{i,j};
            else if (a[i]+a[j]>s) {
                j--;
            }else {
                i++;
            }

        }

        return new int[]{-1,-1};
    }
}
