package TheamLeet.C_15;

public class A {
    public static void main(String[] args) {

        int total=20;
        int p=10;
        int pencil=5;
        System.out.println(waysToBuyPensPencils(total,p,pencil));

    }
    public static long waysToBuyPensPencils(int total, int cost1, int cost2) {


        long way = findWay(total, cost1, cost2);
        if (way==0) return 1;
        return way;

    }

    private static long findWay(int total, int cost1, int cost2) {

        if (total==0)return 0;

        long pen= 0;
        long pencil=0;

      // i have two option take the pen or nor take;



        pen=1+findWay(total-cost1,cost1,cost2); // take the pen
        pencil=1+findWay(total-cost2,cost1,cost2);

        return  pen+pencil;
    }
}
