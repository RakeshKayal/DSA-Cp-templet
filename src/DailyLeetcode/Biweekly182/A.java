package DailyLeetcode.Biweekly182;

public class A {
    public static void main(String[] args) {

        String[] e= {"W","W","W","W","W","W","W","W","W","W","W"};

        int[] ints = scoreValidator(e);
        System.out.println(ints[0]+" : "+ints[1]);

    }
    public static int[] scoreValidator(String[] events) {

        int score=0;
        int c=0;
        for( int i=0;i<events.length;i++){

            if (c==10) break;

            if(events[i].equals("WD")|| events[i].equals("NB")){
                score++;
            }else if(events[i].equals("W")){
                c++;
            }
            else{

                int a= events[i].charAt(0)-'0';
                score+=a;
            }
        }

        return new int []{score,c};

    }
}
