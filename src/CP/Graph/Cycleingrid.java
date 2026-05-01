package CP.Graph;

public class Cycleingrid {
    public static void main(String[] args) {


        char[][] c={
                {'a','a','a','a'},
                {'c','b','b','a'},
                {'a','b','b','a'},
                {'a','a','a','a'}
        };

        boolean b = containsCycle(c);
        System.out.println(b);

    }
    static  int dr[]={-1,1,0,0};
    static  int dc[]={0,0,-1,1};
    public static boolean containsCycle(char[][] grid) {

        int n= grid.length;
        int m= grid[0].length;



        int visit[][]= new int[n][m];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (visit[i][j]==0 ) {

                    if (dfsCycle(i, j, grid,-1,-1,visit)) return  true;
                }else {
                    continue;
                }
            }
        }

        return  false;

    }

    private static boolean dfsCycle(int i, int j, char[][] grid, int p1, int p2, int[][] visit) {
        visit[i][j]=1;

        for (int k = 0; k < 4; k++) {

            int nr= i+dr[k];
            int nc= j+dc[k];

            if (nr==p1 && nc==p2) continue;

            if (nr>=0 && nc>=0 && nr<grid.length && nc<grid[0].length  && grid[nr][nc]== grid[i][j]  ){

                if (visit[nr][nc]==0){
                    if (dfsCycle(nr,nc,grid,i,j,visit)) return  true;
                } else if (nr!=p1 && nc!=p2) {
                    return  true;
                }
            }

        }
        return  false;
    }
}
