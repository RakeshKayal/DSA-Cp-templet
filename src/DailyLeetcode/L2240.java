package DailyLeetcode;

public class L2240 {
    public static void main(String[] args) {

        int total=5;
        int cost1=10;
        int cost2=10;
        System.out.println(waysToBuyPensPencils(total,cost1,cost2));



    }
    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {


        int n=((total/cost1>=0)?total/cost1:0) +1;
//        int m=((total/cost2>=0)?total/cost2:0)+1;

        long way=0;

        for (int pen = 0; pen < n; pen++) {
            int to=total;
          int penBuy=pen*cost1;
          int maxPencils=(to-penBuy)/cost2;
          way+=(maxPencils+1);

        }

        return  way;


    }
}
