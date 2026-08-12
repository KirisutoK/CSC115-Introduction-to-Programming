// Creation Date: August 11, 2026. at 8:36 PM
// Last Modified: August 12, 2026. at  6:38 PM

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args)  {
        String s = "the quick brown fox jumps over the lazy dog";

        // [SB01]
        StringBuilder sb01 = new StringBuilder(s);
        sb01.reverse();

        // [SB02]
        StringBuilder sb02 = new StringBuilder(s);
        sb02.setCharAt(0, Character.toUpperCase(sb02.charAt(0)));
        for (int i = 0; i < sb02.length(); i++) {
            if (sb02.charAt(i) == ' ') {
                sb02.setCharAt(i+1, Character.toUpperCase(sb02.charAt(i+1))); ;
            }
        }

        // [Vowels]
        int vowels = 0;
        for (char c:s.toCharArray()) {
            if (c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') {
                vowels++;
            } else if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowels++;
            }
        }


        // [PRINTING DISPLAY]
        System.out.println("SB01: "+sb01);
        System.out.println("SB02: "+sb02);
        System.out.println("Vowels: "+vowels);
    }

    // =========================== METHODS =========================== \\
}
