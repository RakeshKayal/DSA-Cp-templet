package Generic;

import java.util.ArrayList;
import java.util.List;

public class L {
    static {
        System.out.println("static");  // static block is always run first
    }
    public static void main(String[] args) {

        System.out.println("main");


        try {
            int ans=2/0;
            System.out.println(ans);
        }catch (ArithmeticException e){
            System.out.println(e.getLocalizedMessage());
        }
        finally {
            System.out.println("Always run");  // finally block always run
        }


    }

}
