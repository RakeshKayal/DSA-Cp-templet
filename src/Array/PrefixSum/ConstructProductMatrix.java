package Array.PrefixSum;

public class ConstructProductMatrix {
    static  int mod= 1234;
    public static void main(String[] args) {

        int mat[][]={
                {1,2},
                {3,4}
        };


        int[][] fs1 = fs(mat);

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(fs1[i][j]+" ");
            }
            System.out.println();
        }
    }

    private static int[][] fs(int[][] mat) {


        int n= mat.length;
        int m= mat[0].length;


        int total=n*m;


        int idx=0;
        int flat[]= new int[total];
        for(int i=0;i<n;i++){
            for (int j = 0; j < m; j++) {
                flat[idx++]=mat[i][j];

            }
        }


        // prefix;
        int prefix[]= new int[total];

        prefix[0]= 1;
        for (int i = 1; i <total ; i++) {
            prefix[i]=(prefix[i-1] *flat[i-1])%mod;
        }

        //suffix

        int suffix[]= new int[total];
        suffix[total-1]=1;

        for (int i = total-2; i >=0 ; i--) {
            suffix[i]=(suffix[i+1]* flat[i+1])%mod;
        }

        int ans[][]= new int[n][m];

 idx=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                ans[i][j]=(prefix[idx]* suffix[idx])%mod;
                idx++;
            }
        }

        return ans;
    }
}
