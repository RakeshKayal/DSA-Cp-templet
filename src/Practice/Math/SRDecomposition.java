package Practice.Math;

public class SRDecomposition {

    public static void main(String[] args) {

        int n[]={2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};


        int[][] q= {
                {0,2},
                {1,7},
                {1,4},
                {0,14}
        };  // you can use prefix sum ..

        // but when it needed the most

        int s = (int) Math.ceil(Math.sqrt(n.length)); // block size = 4
        int numBlocks = (int) Math.ceil((double) n.length / s);
        int[] b = new int[numBlocks];


        for (int i = 0; i < n.length; i++) {

            int b_no=i/s;
            b[b_no]+= n[i];
        }



        // query

        for(int [] it : q){

            int l=it[0];
            int r=it[1];


            int b_l=l/s;
            int b_r= r/s;

            if(b_l==b_r){  // when both are in same block
                int sum=0;
                for (int i = l; i <=r ; i++) {
                    sum+=n[i];
                }
                System.out.println(sum);
            }
            else {

                int l_block=l/s;

                int l_startIndex=l_block*s;  // it's easy to find
                int l_lastIndex=((l_block+1)*s)-1;

                int r_block=r/s;
                int r_startIndex=r_block*s;


                // for partial L

                int sum=0;
                for (int i = l; i <=l_lastIndex ; i++) {
                    sum+=n[i];
                }

                // middle block

                for (int i = l_startIndex+1; i <r_block ; i++) {
                    sum+=b[i];
                }

                // last partial block
                for (int i = r_startIndex; i <=r ; i++) {
                    sum+=n[i];
                }

                System.out.println(sum);

            }
        }
    }
}
