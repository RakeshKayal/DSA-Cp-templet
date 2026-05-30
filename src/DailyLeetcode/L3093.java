package DailyLeetcode;

import java.util.*;

public class L3093 {
    public static void main(String[] args) {

    }
    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {


        List<String > w= new ArrayList<>();
        List<String > q= new ArrayList<>();

        Map<String ,Integer> m= new HashMap<>();

        for (int i=0;i<wordsContainer.length;i++ ){

            String string = revSt(wordsContainer[i]);
            w.add(string);
            m.put(string,i);

        }
        for (int i=0;i<wordsQuery.length;i++ ){

            String string = revSt(wordsQuery[i]);
            w.add(string);


        }

        Collections.sort(w);
        int ans[]= new int[q.size()];



        for (String  it: q){

            for (int i = 0; i < w.size(); i++) {

                cheackforMin(it,w.get(i));
            }

        }
        return new int[]{0,0};

    }

    private int cheackforMin(String it, String s) {

        return 0;



    }

    private String  revSt(String it) {

        char[] charArray = it.toCharArray();
        int i=0;
        int j=charArray.length-1;
        while (i<j){
            char temp= charArray[i];
            charArray[i]=charArray[j];
            charArray[j]=temp;
            i++;
            j--;
        }
        return  new String(charArray);
    }
}
