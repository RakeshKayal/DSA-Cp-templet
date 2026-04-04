package CP.Contest.Round1090;

import java.io.*;

public class Div4 {

    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
     static PrintWriter out= new PrintWriter(new BufferedOutputStream(System.out));
    public static void main(String[] args) throws IOException {

        int t= Integer.parseInt(br.readLine());

        while (t-->0){

            int x= Integer.parseInt(br.readLine());


            if (x==67) out.println(67);
            else {
                out.println(x+1);
            }
            out.flush();
        }

    }
}
