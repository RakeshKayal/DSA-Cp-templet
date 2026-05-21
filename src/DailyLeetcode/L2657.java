package DailyLeetcode;

public class L2657 {
    public static void main(String[] args) {

    }
    public static int[] findThePrefixCommonArray(int[] A, int[] B) {

        int n= A.length;
        int max=n;
        boolean seen[]= new boolean[max+1];

        int ans[]= new int[A.length];

        if (A[0]==B[0]){
            ans[0]=1;
            seen[A[0]]=true;
            seen[B[0]]=true;
        }
        else {
            ans[0]=0;
            seen[A[0]]=true;
            seen[B[0]]=true;
        }
        for (int i = 1; i <ans.length ; i++) {


            if (A[i]==B[i]){
                seen[A[i]]=true;
                seen[B[i]]=true;
                ans[i]=ans[i-1] +1;
            }else{

                int u=A[i];
                int v=B[i];

                int c=0;
                if (seen[u]){
                    c++;
                }else{
                    seen[u]=true;
                }
                if (seen[v]){ c++;
                }else{
                    seen[v]=true;
                }

                ans[i]=ans[i-1]+c;

            }
        }

        return  ans;



    }
}
