package CodeForces.Graph;

import java.util.*;

class  ds1{
    List<Integer> rank =new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();

    ds1(int n){
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
public class Secret {
    public static void main(String[] args) {

        int n = 6;
        int[][]meetings = {
                {1,2,5},
                {2,3,8},
                {1,5,10}
        };
        int firstPerson = 1;
        List<Integer> allPeople = findAllPeople(n, meetings, firstPerson);
        System.out.println(allPeople);

    }

    public  static List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {

        ds1 ob = new ds1(n);
        Set<Integer> s= new HashSet<>();
        s.add(0);
        s.add(firstPerson);
        ob.unionByRanks(0,firstPerson);


        Map<Integer, List<int[]>> m= new TreeMap<>();

        for( int a[]: meetings){

            m.put(a[2],new ArrayList<>());
            m.get(a[2]).add(a);
        }


        for (Map.Entry<Integer, List<int[]>> integerListEntry : m.entrySet()) {

            List<int[]> value = integerListEntry.getValue();

            for( int[] a: value){
                ob.unionByRanks(a[0],a[1]);
            }

            for (int[] a: value){

                if (ob.findRoot(a[0])==ob.findRoot(0)){
                    s.add(a[0]);
                    s.add(a[1]);
                }
            }

        }

        List<Integer> ans= new ArrayList<>();
        for( int a:s){
            ans.add(a);
        }

        return ans;

    }
}
