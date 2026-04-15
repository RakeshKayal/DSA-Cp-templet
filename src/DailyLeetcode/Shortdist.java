package DailyLeetcode;

public class Shortdist {
    public static void main(String[] args) {
      String [] words = {"hello","i","am","leetcode","hello"};
      String target = "hello";
      int startIndex = 1;

        int i = closestTarget(words, target, startIndex);
        System.out.println(i);
    }

    public static int closestTarget(String[] words, String target, int startIndex) {

        boolean f=true;
        for (int i = 0; i < words.length; i++) {

            if (words[i]==target){
                f=false;
            }
        }

        if (f) return -1;
        boolean visit[]= new boolean[words.length];

        return  sloveS(startIndex,words,target,0,visit);

    }

    private static int sloveS(int i, String[] words, String target, int c, boolean[] visit) {

        if(visit[i])return (int) 1e9;
        if (words[i]==target){
            return c;
        }
        visit[i]=true;


        int left= sloveS(((i-1+words.length)%words.length),words,target,c+1, visit);
        int right= sloveS(((i+1)%words.length), words,target,c+1, visit);
        visit[i]=false;

        return  Math.min(left,right);
    }
}
