package CodeForces.Graph;

import java.util.PriorityQueue;

public class SwimRisingWater {
    public static void main(String[] args) {


        int mat[][]={
                {0,2},
                {1,3}
        };

        int i = swimInWater(mat);
        System.out.println(i);

    }

    static  int dr[]={0,1,0,-1};
    static  int dc[]={1,0,-1,0};
    public  static int swimInWater(int[][] grid) {

        class  tuple{
            int r;
            int c;
            int t;

            tuple( int r, int c, int t){
                this.r=r;
                this.c=c;
                this.t=t;
            }
        }

        int n=grid.length;
        int m= grid[0].length;

        int f= grid[0][0];

        int visit[][]= new int[n][m];

        PriorityQueue<tuple> pq= new PriorityQueue<>((a,b)->a.t-b.t);
//        visit[0][0]=1;
        pq.add(new tuple(0,0,f));

        while (!pq.isEmpty()){

            tuple t= pq.poll();
            int r=t.r;
            int c= t.c;
            int cur_t= t.t;

            if (visit[r][c]!=0) continue;
            visit[r][c]=1;

            if (r==n-1 && c==m-1) return cur_t;


            for (int i = 0; i < 4; i++) {
                int nr= r+dr[i];
                int nc= c+dc[i];

                if(validR(nr,nc, n,m) && visit[nr][nc]!=1){


                    int nextTime= Math.max(cur_t, grid[nr][nc]);


                    pq.add(new tuple(nr,nc,nextTime));

                }
            }
        }

        return  -1;

    }

    private static boolean validR(int nr, int nc, int n, int m) {

        return  nr>=0 && nr<n && nc>=0 && nc<m;
    }
}
