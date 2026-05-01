package Array;

public class CountRepeation {
    public static void main(String[] args) {

        String  s1="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa",s2="aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
        int n1=816807;
        int n2=377233;
        int maxRepetitions = getMaxRepetitions1(s1, n1, s2, n2);
        System.out.println(maxRepetitions);

    }
    public  static int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int j = 0;
        int s2Count = 0;


        for (int rep = 0; rep < n1; rep++) {
            for (int i = 0; i < s1.length(); i++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    j++;
                    if (j == s2.length()) {
                        s2Count++;
                        j = 0;
                    }
                }
            }
        }


        return s2Count / n2;


    }
    public  static int getMaxRepetitions1(String s1, int n1, String s2, int n2) {


        String s = "";
        for (int i = 0; i < n1; i++) {
            s += s1;
        }

        int i = 0;
        int j = 0;
        int s2Count = 0;

        while (i < s.length()) {
            if (s.charAt(i) == s2.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }

            if (j == s2.length()) {
                s2Count++;
                j = 0;
            }
        }

        return s2Count / n2;

    }


}
