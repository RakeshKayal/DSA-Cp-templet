package Array;

import java.util.*;

class d1 {
    List<Integer> rank =new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();

    d1(int n){
        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);

        }
    }


    public  int findRoot(int u){

        if (u==parent.get(u)){
            return u;
        }
        int set= findRoot(parent.get(u));
        parent.set(u,set);
        return  parent.get(u);

    }

    public  void unionByRanks(int u, int v){

        int pv= findRoot(u);
        int pu= findRoot(v);

        if (pu==pv) return;

        if (rank.get(pu)==rank.get(pv)){

            parent.set(pv,pu);
            rank.set(pu, rank.get(pu)+1);

        }
        else if (rank.get(u)> rank.get(v)){
            parent.set(pv,pu);


        }else {
            parent.set(pu,pv);

        }



    }

    public  void  unionSize(int u, int v){
        int pu=findRoot(u);
        int pv= findRoot(v);
        if (pu==pv) return;
        if (size.get(pu)>= size.get(pv)){
            size.set(pu, size.get(pu)+size.get(pv));
            parent.set(pv,pu);

        }else {
            size.set(pv, size.get(pu)+size.get(pv));
            parent.set(pu,pv);
        }
    }


}
public class GCDSortArray {
    public static void main(String[] args) {
        int a[] = {7,21,3};
        boolean b = gcdSort(a);
        System.out.println(b);

    }

    public static boolean gcdSort(int[] nums) {


        int n = nums.length;
        int maxVal = 100001;

        d1 ob = new d1(maxVal);

        for (int num : nums) {
            List<Integer> primes = getprimes(num);
            for (int prime : primes) {
                ob.unionByRanks(num, prime); // union the number with its prime
            }
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < n; i++) {
            if (nums[i] != sorted[i]) {

                int j = -1;
                for (int k = 0; k < n; k++) {
                    if (nums[k] == sorted[i]) {
                        j = k;
                        break;
                    }
                }

                if (ob.findRoot(i) != ob.findRoot(j)) {
                    return false;
                }
            }
        }
        return  true;

    }

    private static List<Integer> getprimes(int n) {
        List<Integer> primes = new ArrayList<>();
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                primes.add(i);
                while (n % i == 0) n /= i;
            }
        }
        if (n > 1) primes.add(n); // n itself is prime
        return primes;
    }

    private static int gcds(int a, int b) {
        if (b == 0) return a;
        return gcds(b, a % b);
    }
}
