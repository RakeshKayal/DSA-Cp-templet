package CodeForces.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BallMenFord {
    public static void main(String[] args) {

        int edge[][]={
                {3,2,6},
                {5,3,1},
                {0,1,5},
                {1,5,-3},
                {1,2,-2},
                {3,4,-2},
                {2,4,3}
        };



        int n=6;






        int dist[]= new  int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0]=0;

        for (int i = 0; i < n - 1; i++) {
            for (int[] it : edge) {
                int u = it[0];
                int v = it[1];
                int w = it[2];

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        //for (-) cycle

        for (int[] it : edge) {
            int u = it[0];
            int v = it[1];
            int w = it[2];

            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                System.out.println("it have Negetive cycle");
                int temp[]= new int[1];
                temp[0]=-1;


            }
        }

        for (int i : dist) {
            System.out.print(i+" ");
        }

    }
}
