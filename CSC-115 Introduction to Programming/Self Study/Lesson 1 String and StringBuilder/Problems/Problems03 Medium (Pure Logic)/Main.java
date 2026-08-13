// Creation Date: August 13, 2026. at 6:18 PM
// Last Modified: August 13, 2026. at  6:36 PM

import java.util.HashMap;

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        System.out.println("1. listen / silent : "+isAnagram("listen", "silent"));
        System.out.println("2. The Morse Code / Here Come Dots : "+isAnagram("The Morse Code", "Here Come Dots"));
        System.out.println("1. hello / world : "+isAnagram("hello", "world"));
    }

    // =========================== METHODS =========================== \\
    public static boolean isAnagram(String s1, String s2) {
        HashMap<Character, Integer> CharacterCounts01 = new HashMap<>();
        HashMap<Character, Integer> CharacterCounts02 = new HashMap<>();

        // COUNTING EACH FOR S1
        for (char c:s1.toCharArray()) {
            if (c == ' ') {
                continue;
            }

            c = Character.toUpperCase(c);

            if (CharacterCounts01.containsKey(c)) {
                CharacterCounts01.put(c, CharacterCounts01.get(c)+1);
            } else {
                CharacterCounts01.put(c, 1);
            }
        }

        // COUNTING EACH FOR S2
        for (char c:s2.toCharArray()) {
            if (c == ' ') {
                continue;
            }

            c = Character.toUpperCase(c);

            if (CharacterCounts02.containsKey(c)) {
                CharacterCounts02.put(c, CharacterCounts02.get(c)+1);
            } else {
                CharacterCounts02.put(c, 1);
            }
        }

        return CharacterCounts01.equals(CharacterCounts02);
    }
}
