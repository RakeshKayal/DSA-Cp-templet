package DailyLeetcode;

import java.util.*;

public class L1345 {
    public static void main(String[] args) {
        int a[]={7};

        System.out.println(minJumps(a));

    }
    public static int minJumps(int[] arr) {

        int n=arr.length;
        if (n==1) return 0;

        Map<Integer, List<Integer>> map= new HashMap<>();

        for (int i = 0; i < arr.length; i++) {

            map.computeIfAbsent(arr[i],k->new ArrayList<>()).add(i);
        }

        class  t{
            int cur;
            int step;
            t( int cur, int step){
                this.cur=cur;
                this.step=step;
            }
        }

        Queue<t> q= new LinkedList<>();


        int visit[]= new int[n];

        q.add(new t(0,0));
        visit[0]=1;
        while (!q.isEmpty()){

            int s=q.size();
            while (s-- >0){
                t p= q.poll();
                int cur=p.cur;
                int step=p.step;

                if (cur==n-1){
                    return step;
                }

                int pos=cur+1;
                int neg= cur-1;
                if (pos<n && visit[pos]!=1){
                    q.add(new t(pos,step+1));
                    visit[pos]=1;
                }
                if (neg>=0 && visit[neg]!=1){
                    q.add(new t(neg,step+1));
                    visit[neg]=1;
                }

                for(int idx: map.get(arr[cur])){
                    if (visit[idx]!=1){
                        q.add(new t(idx,step+1));
                        visit[idx]=1;
                    }
                }
                map.remove(arr[cur]);

            }



        }
        return -1;

    }
}
