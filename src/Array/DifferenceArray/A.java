package Array.DifferenceArray;

public class A {
    public static void main(String[] args) {

        int a[]={0,0,0,0,0};
        int [][] q={  // update th array base on range and return final output
                {1,3,2},
                {2,4,3},
                {0,2,-2}
        };

        //one of the wy you can do this by iterating every time  ~0(q*n)

        // difference Array Technique


       int n=a.length;
//        int [] diff= new int[n];
        for(int [] it : q){
            int s=it[0];
            int end= it[1];
            int val=it[2];
            a[s]+=val;
            if (end+1<n){
                a[end+1]-=val;
            }

        }

        // prefix sum
//        int p[]= new int[n];
//        p[0]=a[0];
//        for (int i = 1; i < n; i++) {
//            p[i]=p[i-1]+a[i];
//        }
        for (int i = 1; i < n; i++) {
            a[i]=a[i-1]+a[i];
        }


        // out put

        for (int i = 0; i < n; i++) {
            System.out.print( a[i]+" ");
        }
    }
}
