// Creation Date: August 12, 2026. at 7:17 PM
// Last Modified: August 12, 2026. at  7:22 PM

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        System.out.println("1. Racecar : "+isPalindrome("racecar"));
        System.out.println("2. Level : "+isPalindrome("Level"));
    }

    // =========================== METHODS =========================== \\
    public static boolean isPalindrome(String s) {
        String r = String.valueOf(new StringBuilder(s).reverse());

        return (r.equalsIgnoreCase(s));
    }
}
