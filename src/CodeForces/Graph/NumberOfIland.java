package CodeForces.Graph;


public class NumberOfIland {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };


        int i = numIslands(grid);
        System.out.println(i);

    }
    static  int dr[]={0,1,0,-1};
    static  int dc[]={1,0,-1,0};
    public  static int numIslands(char[][] grid) {


        int n=grid.length;
        int m= grid[0].length;
        int ans=0;

        int visit[][]= new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if(grid[i][j]=='1' && visit[i][j]==0){
                    ans++;
                    dfsfindNo(grid,i,j,n,m, visit);

                }
            }
        }

        return  ans;
    }

    private static void dfsfindNo(char[][] grid, int i, int j, int n, int m, int[][] visit) {
        visit[i][j]=1;


        for( int k=0;k<4;k++){

            int nr= i+dr[k];
            int nc=j+dc[k];

            if(validR(nr,nc,n,m) && visit[nr][nc]==0 && grid[nr][nc]=='1'){
                dfsfindNo(grid,nr,nc,n,m,visit);
            }
        }
    }

    private static boolean validR(int nr, int nc, int n, int m) {
        return  nr>=0 && nr<n && nc>=0 && nc<m;
    }
}
