package CP.implementation;

import java.io.*;
import java.util.StringTokenizer;

public class FoxAndSnake {
    static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out= new PrintWriter(new BufferedOutputStream(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st= new StringTokenizer(br.readLine());

        int n=Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());

        boolean f=true;
        for (int i = 0; i < n; i++) {
            boolean come= false;
            for (int j = 0; j < m; j++) {

                if (i%2==0){
                    System.out.print('#');
                }else {
                    come=true;

                    if (f){

                        if (j==m-1) System.out.print('#');
                        else {
                            System.out.print('.');
                        }

                    }else {
                        if (j==0) System.out.print('#');
                        else {
                            System.out.print('.');
                        }

                    }
                }
            }
            if(come){
                f=!f;
            }
            System.out.println();
        }
    }
}
