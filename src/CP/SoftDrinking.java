package CP;

import java.io.*;
import java.util.StringTokenizer;

public class SoftDrinking {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //no of people
        int k = Integer.parseInt(st.nextToken()); // no of bottles
        int l=Integer.parseInt(st.nextToken()); // milliliters  in each
        int c=Integer.parseInt(st.nextToken());// limes
        int d=Integer.parseInt(st.nextToken());// slice the lime
        int p= Integer.parseInt(st.nextToken());// p gram of salt
        int nl=Integer.parseInt(st.nextToken());// need nl milliliters each n
        int np= Integer.parseInt(st.nextToken()); // np gram of salt



        int t_milliter= k*l;

        int n_t=t_milliter/nl;

        int l_cut= c*d;
        int need_salt=p/np;

        int minToast=Math.min(n_t,Math.min(l_cut,need_salt));
        out.println(minToast/n);
        out.flush();




    }
}
