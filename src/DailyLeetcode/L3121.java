package DailyLeetcode;

import java.util.*;

public class L3121 {
    public static void main(String[] args) {
        String  word="AbBCab";
        String word1="AAbaacBC";
        System.out.println(numberOfSpecialChars(word1));
        System.out.println(numberOfSpecialChars(word));

    }
    public static int numberOfSpecialChars(String word) {

        Map<Character, List<Integer>> map= new HashMap<>();

        int count=0;


        for (int i = 0; i < word.length(); i++) {


            int c= word.charAt(i);

            if (c>=97){
               map.computeIfAbsent(word.charAt(i),k->new ArrayList<>()).add(i);
            }
        }
        System.out.println(map);


        for (int i = 0; i < word.length(); i++) {


            int cur= word.charAt(i);


            if (cur>=65 && cur<=90){

                char convert= (char) (cur+32);
               // System.out.println(convert);

                List<Integer> list = map.getOrDefault(convert, Collections.emptyList());
               // System.out.println(list);

                boolean flag=true;
                if (list != null && !list.isEmpty()) {
                    for (int l : list) {

                      //  System.out.println(l+": "+i);
                        if (l > i) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag){
                        count++;
                    }
                }


                map.remove(convert);

            }
        }


        return  count;






    }
}
