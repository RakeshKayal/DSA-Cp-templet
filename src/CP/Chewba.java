package CP;

import java.util.Scanner;

public class Chewba {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        String  no= sc.nextLine();

        int t=0;
        char c[]= no.toCharArray();
        while (t<c.length){

            int digit = c[t] - '0';
            int complement = 9 - digit;

            if (t == 0 && complement == 0){
                t++;
                continue;
            }

            if (complement < digit) {
                c[t] = (char) ('0' + complement);
            }
            t++;
        }
        System.out.println(new String(c));
    }
}
