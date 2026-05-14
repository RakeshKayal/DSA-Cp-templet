package DailyLeetcode;

public class Train {
    public static void main(String[] args) {

        int d[]={1,3,2};
        double h=1.9;
        System.out.println(minSpeedOnTime(d,h));

    }
    public static int minSpeedOnTime(int[] dist, double hour) {
        
//        int s=sum(dist);
//
//        if (s<hour) return -1;


        int l=1;
        int h=(int) 1e7;

        int ans=-1;
        while (l<=h){

            int speed=l+(h-l)/2;
            double reach = canReach(speed, dist);
           // System.out.println(speed + " : "+reach);

            if (reach<=hour){
                ans=speed;
                h=speed-1;
            }
            else {
                l=speed+1;
            }
        }
        return ans;

    }

    private static double canReach(int speed, int[] dist) {

        // i need ceil value;

        double sum=0;
        for( int i=0;i<dist.length-1;i++){
            sum = sum + Math.ceil((double) dist[i] / speed);
        }
        return sum+ (double) dist[dist.length - 1] /speed;



    }

    private static int sum(int[] dist) {

        int s=0;
        for (int i = 0; i < dist.length; i++) {
            s+=dist[i];
        }
        return  s;
    }
}
