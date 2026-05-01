package Array;

import java.util.ArrayList;
import java.util.List;

public class TwoWord {
    public static void main(String[] args) {

        String [] q={"tsl","sri","yyy","rbc","dda","qus","hyb","ilu","ahd"};
        String [] d={"uyj","bug","dba","xbe","blu","wuo","tsf","tga"};
        List<String> list = twoEditWords(q, d);
        System.out.println(list);

    }
    public  static List<String> twoEditWords(String[] queries, String[] dictionary) {

        List<String > ans= new ArrayList<>();

        int n =dictionary.length;
        int m= queries.length;

        for (int i = 0; i < m; i++) {

            String  word= queries[i];
            for (int j = 0; j < n; j++) {

                if (isValidString(word,dictionary[j])){
                    ans.add(word);
                    break;
                }
            }
        }

        return  ans;

    }

    private static boolean isValidString(String word, String query) {

        int i=0;
        int j=0;
        int c=0;
        while (i<word.length())
        {
            if (word.charAt(i)!=query.charAt(j)){
                c++;
            }
            i++;
            j++;
        }


        return c<=2;
    }
}
