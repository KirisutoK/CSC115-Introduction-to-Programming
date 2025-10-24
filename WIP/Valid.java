import java.util.Random;
import java.util.Scanner;

public class Valid {
    public static void main(String []args) {
        String Password = "QAZwsx123";

        int Line = 0;
        int TotalLine = Password.length();

        int ValidPoints = 0;

        while (Line < TotalLine) {  
            int CharactersDecimal = Password.charAt(Line); // Turns Char into Decimals?
            char Words = (char)CharactersDecimal; // Decimals into Char?
            
            System.out.println(Words);
            System.out.println(CharactersDecimal);
            Line++;
            //ASCI Uppercase (65-90)
            if (CharactersDecimal >= 65 && CharactersDecimal <= 90) {
                boolean Valid = true;
                ValidPoints++;
                System.out.println("Valid");
            } else {
                boolean Valid = false;
                System.out.println("Not Valid");
            }

            System.out.println(ValidPoints);
        }
    }
}
