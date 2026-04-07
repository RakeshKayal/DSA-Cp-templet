package CodeForces.Graph;

import java.util.Arrays;

public class FloydWerSell {
    public static void main(String[] args) {


        int edge[][]={

                {0,1,2},
                {1,0,1},
                {1,2,3},
                {3,2,4},
                {3,0,3},
                {3,1,5},
        };

        int n=4;

        int [][] adjmat= new int[n][n];
        for (int [] row : adjmat){
            Arrays.fill(row,(int)1e9);
        }
        for (int i = 0; i < n; i++) adjmat[i][i] = 0;

        for(int it []:edge){
            int u=it[0];
            int v=it[1];
            int w= it[2];
            adjmat[u][v]= w;

        }




        for( int v=0;v<n;v++){
            for (int i = 0; i < adjmat.length; i++) {
                for (int j = 0; j < adjmat[0].length; j++) {

                    adjmat[i][j]=Math.min(adjmat[i][j],adjmat[i][v]+adjmat[v][j]);
                }
            }
        }

        // for negative cycle
        for (int i = 0; i < n; i++) {

            if (adjmat[i][i]<0){
                System.out.println("negative cycle");
            }
        }

        for (int i = 0; i < adjmat.length; i++) {
            for (int j = 0; j < adjmat[0].length; j++) {

                System.out.print(adjmat[i][j]+ " ");
            }
            System.out.println();
        }

    }
}
