package Array.TwoPointer;

import java.util.Scanner;

public class bit {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        int t= sc.nextInt();
        sc.nextLine();
        int ans=0;

        while (t-- >0){

            String s=sc.nextLine();

            if (s.contains("++")){
                ans+=1;
            }else {
                ans-=1;
            }

        }
        System.out.println(ans);

    }
}
