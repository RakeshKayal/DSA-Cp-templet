package DailyLeetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class L2850 {
    public static void main(String[] args) {

    }
    public int minimumMoves(int[][] grid) {

        Set<String > st=new HashSet<>();
        class  pair{
            int i;
            int j;
            pair(int i, int j){
                this.i=i;
                this.j=j;
            }
        }
        int n= grid.length;
        int m=grid[0].length;
        int visit[][]= new int[n][m];

        Queue<pair> q= new LinkedList<>();

        int c=0;
        for (int i = 0; i < grid.length; i++) {

            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j]==0){
                    c++;
                    String s=i+"_"+j;
                    st.add(s);
                } else if (grid[i][j]>1) {
                    q.add(new pair(i,j));
                    visit[i][j]=1;
                }
            }
        }

        if (c==8) return 8;
        int moves=0;
        int dr[]={0,0,-1,1};
        int dc[]={-1,1,0,0};



        while (!q.isEmpty()){

            pair poll = q.poll();
            int i=poll.i;
            int j=poll.j;

            for (int k = 0; k < 4; k++) {

                int nr= i+dr[k];
                int nc=j+dc[k];

                if (nr>=0 && nr< grid.length && nc>=0 && nc<grid[0].length && visit[nr][nc]==0){


                }
            }
        }
        return 0;

    }
}
