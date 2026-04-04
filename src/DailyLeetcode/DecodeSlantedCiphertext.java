package DailyLeetcode;

public class DecodeSlantedCiphertext {
    public static void main(String[] args) {

        String encodedText = "iveo    eed   l te   olc";


        int rows = 4;



        String string = decodeCiphertext(encodedText, rows);
        System.out.println(string);

    }


    public static String decodeCiphertext(String encodedText, int rows) {

        if (rows==1)
        {
            return encodedText;
        }


        int cols = encodedText.length() / rows;
        int going=cols+1;

        StringBuilder sb= new StringBuilder();

        for (int i = 0; i < cols; i++) {

            sb.append(encodedText.charAt(i));

            int f=i+going;
            for (int j = cols; j < encodedText.length(); j++) {


                if (j==f){
                    sb.append(encodedText.charAt(j));
                    f=j+going;
                }
            }

        }
        return  sb.toString().stripTrailing();





    }
}
