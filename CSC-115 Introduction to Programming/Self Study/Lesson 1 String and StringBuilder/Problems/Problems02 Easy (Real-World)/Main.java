// Creation Date: August 12, 2026. at 7:24 PM
// Last Modified: August 12, 2026. at  7:39 PM

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        System.out.println("1. john_doe123 : "+isValidUserName("john_doe123"));
        System.out.println("2. 5tarWars : "+isValidUserName("5tarWars"));
        System.out.println("3. al : "+isValidUserName("al"));
        System.out.println("4. this_username_is_way_too_long : "+isValidUserName("this_username_is_way_too_long"));
        System.out.println("5. john doe : "+isValidUserName("john doe"));
        System.out.println("6. validUser1 : "+isValidUserName("validUser1"));
    }

    // =========================== METHODS =========================== \\
    public static boolean isValidUserName(String s) {

        if (s.length() < 5 || s.length() > 15) {
            System.out.println("The username is less than or equal to 5 or more than or equal to 15");
            return false;
        } else if (s.contains(" ")) {
            System.out.println("The username must not include a space");
            return false;
        } else if (Character.isDigit(s.charAt(0))) {
            System.out.println("The usernmae must not start with a number");
            return false;
        }


        return true;
    }
}
