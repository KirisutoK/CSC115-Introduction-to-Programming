// Creation Date: August 14, 2026. at 7:33 PM
// Last Modified: August 21, 2026. at  9:20 PM

import java.util.HashMap;

public class StringUtils {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== CONSTRUCTOR =========================== \\


    // =========================== METHODS =========================== \\
    // [STRING MODIFICATION]
    // Uses: Formatting
    public static String camelCase(String s) {
        StringBuilder sb = new StringBuilder(s);

        sb.setCharAt(0, Character.toUpperCase(sb.charAt(0)));
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                sb.setCharAt(i+1, Character.toUpperCase(sb.charAt(i+1)));
            }
        }

        return sb.toString();
    }
    public static String reverseCamelCase(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                sb.setCharAt(i-1, Character.toUpperCase(sb.charAt(i-1)));
            }
        }

        return sb.toString();
    }
    public static String removeSpaces(String s) {
        s = s.trim();
        String[] Lines = s.split(" ");
        StringBuilder sb = new StringBuilder();

        for (String l:Lines) {
            sb.append(l);
        }

        return sb.toString();
    }


    // [STRING GAMES]
    // Uses: Requirements
    public static boolean isPalindrome(String s) {
        String r = String.valueOf(new StringBuilder(s).reverse());

        return (r.equalsIgnoreCase(s));
    }
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

    // [HIDE VALUE]
    // Uses: Password
    public static String hideValue(String s) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ') {
                sb.setCharAt(i, '•');
            }
        }

        return sb.toString();
    }
    public static String hideValue(String s, char letters) {
        StringBuilder sb = new StringBuilder(s);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ') {
                sb.setCharAt(i, letters);
            }
        }

        return sb.toString();
    }
    public static String hideValue(String s, char letters, int show) {
        StringBuilder sb = new StringBuilder(s);
        int limit = sb.length() - show;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ' && i < limit) {
                sb.setCharAt(i, letters);
            }
        }

        return sb.toString();
    }
    public static String hideValue(String s, int show) {
        StringBuilder sb = new StringBuilder(s);
        int limit = sb.length() - show;

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != ' ' && i < limit) {
                sb.setCharAt(i, '•');
            }
        }

        return sb.toString();
    }

    // [EFFECTS]
    // Uses: Game Development
    public static void Dialogue(String Dialogue, int DialogueSpeed) { // Prints each word by word with a delay making it look like a typing effect
        try {
            for (char c : Dialogue.toCharArray()) {
                System.out.print(c);
                Thread.sleep(DialogueSpeed);
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
    public static void Dialogue(String Dialogue) { // Prints each word by word with a delay making it look like a typing effect
        try {
            for (char c : Dialogue.toCharArray()) {
                System.out.print(c);
                Thread.sleep(250);
            }
        } catch (InterruptedException e) {
            System.out.println("ERROR: "+e.getMessage());
        }
    }
 }
