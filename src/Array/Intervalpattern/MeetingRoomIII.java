package Array.Intervalpattern;

import java.util.Arrays;

public class MeetingRoomIII {
    public static void main(String[] args) {
        int n = 2;
        int meetings[][] = {
                {0, 6},
                {2, 3},
                {3, 7},
                {4, 8},
                {6, 8}
        };

        int ans= mostBooked(n,meetings);
        System.out.println(ans);


    }
    public  static int mostBooked(int n, int[][] meetings) {
        // code here

        int [] availableRoom= new int [n];
        int [] useRoom=new int [n];

        Arrays.sort(meetings,(a, b)->a[0]-b[0]);


        for( int meet=0;meet<meetings.length;meet++){

            int start=meetings[meet][0];
            int end=meetings[meet][1];
            int duration=end-start;

            boolean found=false;
            long earlyEndRoomTime = Long.MAX_VALUE;
            int earlyEndRoom = 0;

            for( int room=0;room<n;room++){
                if(availableRoom[room]<=start){
                    availableRoom[room]=end;
                    useRoom[room]++;
                    found=true;
                    break;
                }
                if (availableRoom[room] < earlyEndRoomTime) {
                    earlyEndRoom = room;
                    earlyEndRoomTime = availableRoom[room];
                }
            }

            if(!found){

                availableRoom[earlyEndRoom]=availableRoom[earlyEndRoom]+duration;
                useRoom[earlyEndRoom]++;

            }


        }


        int res=0;
        int max=Integer.MIN_VALUE;

        for( int i=0;i<useRoom.length;i++){
            if(max<useRoom[i]){
                max=useRoom[i];
                res=i;
            }
        }

        return res;
    }
}
