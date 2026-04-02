package DailyLeetcode;

import java.util.ArrayList;
import java.util.List;

public class RobotCollision {
    public static void main(String[] args) {


        int p[]={1,2,5,6};
        int h[]={10,10,1,11};
        String d="RLRL";

        List<Integer> survive = survive(p, h, d);
        System.out.println(survive);


    }

    public  static List<Integer> survive(int[] p, int[] h, String d){


        List<Integer> ans= new ArrayList<>();



        for (int i = 0; i < d.length(); i++) {


            if (i>0){

                if(d.charAt(i)=='L' && d.charAt(i-1)=='R'){

                    if (h[i]>h[i-1]){
                       h[i]=h[i]-1;
                       h[i-1]=0;
                    } else if (h[i]<h[i-1]) {
                        h[i]=h[i-1]-1;
                        h[i-1]=0;
                    }
                    else {
                        h[i]=0;
                        h[i-1]=0;
                    }

                }
            }
        }

        for (int i = 0; i < h.length; i++) {

            if (h[i]!=0){
                ans.add(h[i]);
            }
        }

        return  ans;

    }
}
