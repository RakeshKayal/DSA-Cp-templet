package Array;

import java.util.ArrayList;
import java.util.List;

public class KClosestElement {
    public static void main(String[] args) {


         int a[]= {-5,-1,2,5,6,7,8};

         int k=3;
         int x=3;
        List<Integer> k1 = findK(a, k, x);
        System.out.println(k1);
    }

    private static List<Integer> findK(int[] a, int k, int x) {


        int l=0, r=a.length-1;


        if (k==a.length){

            List<Integer> ans= new ArrayList<>();
            for (int i = 0; i < a.length; i++) {

                ans.add(a[i]);
            }
            return  ans;
        }

        while (l<r){

            int mid= (l+r)/2;

            if (a[mid]>=x){
                r=mid;
            }else {
                l=mid+1;
            }
        }

        l=r-1;

        int i=0;
        while (i<k){

            if (l==-1){
                r=r+1;
            } else if (r==a.length-1) {
                l=l-1;
            } else if (Math.abs(a[l]-x)<Math.abs(a[r]-x)) {
                l=l-1;

            } else if (Math.abs(a[l]-x)>Math.abs(a[r]-x)) {
                r=r+1;

            }else {
                l=l-1;
            }
            i++;
        }

        List<Integer> ans= new ArrayList<>();
        for (int j = l+1; j <r ; j++) {
            ans.add(a[j]);
        }
        return ans;
    }
}
