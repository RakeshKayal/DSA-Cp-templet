package DailyLeetcode;

import java.util.HashSet;
import java.util.Set;

public class L3120 {
    public static void main(String[] args) {
        String word= "aaAAbcBC";
        System.out.println(numberOfSpecialChars(word));

    }
    public static int numberOfSpecialChars(String word) {

        Set<Character> s= new HashSet<>();
        int count=0;

        for (int i = 0; i < word.length(); i++) {


            int c= word.charAt(i);

            if (c>=97){
                s.add(word.charAt(i));
            }
        }


        for (int i = 0; i < word.length(); i++) {

            int c=word.charAt(i);

            if (c>=65 && c<=90){

                int convert= c+32;
                char con= (char) convert;
                if (s.contains(con)){
                    count++;
                    s.remove(con);
                }
            }
        }

        return  count;



    }
    
}
