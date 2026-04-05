package CodeForces.Graph;

import java.util.*;

class d {
    List<Integer> rank =new ArrayList<>();
    List<Integer> parent= new ArrayList<>();
    List<Integer> size= new ArrayList<>();

    d(int n){
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
public class MargeAccount {
    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(Arrays.asList("John", "j1@com", "j2@com", "j3@com"));
        accounts.add(Arrays.asList("John", "j4@com"));
        accounts.add(Arrays.asList("Raj", "r1@com", "r2@com"));
        accounts.add(Arrays.asList("John", "j1@com", "j5@com"));
        accounts.add(Arrays.asList("Raj", "r2@com", "r3@com"));
        accounts.add(Arrays.asList("Mary", "m1@com"));

        for (List<String> list : accountsMerge(accounts)) {

            System.out.println(list);
        }


    }

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {

        d ob = new d(accounts.size());


        Map<String, Integer> mail = new HashMap<>();

        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 0; j < accounts.get(i).size(); j++) {
                String mails = accounts.get(i).get(j);


                if (!mail.containsKey(mails)) {
                    mail.put(accounts.get(i).get(j), i);
                } else {
                    ob.unionByRanks(i, mail.get(mails));
                }
            }
        }


        ArrayList<String>[] a = new ArrayList[accounts.size()];
        for (int i = 0; i < accounts.size(); i++) {

            a[i] = new ArrayList<>();

            for (Map.Entry<String, Integer> stringIntegerEntry : mail.entrySet()) {

                String m = stringIntegerEntry.getKey();
                int node = ob.findRoot(stringIntegerEntry.getValue());
                a[node].add(m);

            }
        }

            List<List<String>> ans = new ArrayList<>();

            for (int j = 0; j < accounts.size(); j++) {

                if (a[j].isEmpty()) continue;

                Collections.sort(a[j]);
                List<String> temp = new ArrayList<>();
                temp.add(accounts.get(j).get(0));
                for (String as : a[j]) {
                    temp.add(as);
                }
                ans.add(temp);

            }

            ans.sort((aa, b) -> aa.get(0).compareTo(b.get(0)));
            return ans;


        }
    }

