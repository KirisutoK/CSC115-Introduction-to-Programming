// Creation Date: August 12, 2026. at 6:50 PM
// Last Modified: August 12, 2026. at  7:15 PM

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        // [REMOVING SPACES]
        String s = "  john michael smith  ";
        s = s.trim();
        System.out.println(s);

        // [SPLITTING]
        String[] Fullname = s.split(" ");
        System.out.println("First Name: "+Fullname[0]);
        System.out.println("Middle Name: "+Fullname[1]);
        System.out.println("Last Name: "+Fullname[2]);

        // [COMPARISON] <========= TO SEE THAT == COMPARES THE MEMORY AND NOT THE ACTUAL CONTENT
        String Smith01 = new String("Smith");
        String Smith02 = "Smith";

        System.out.println("== : "+ (Smith01 == Smith02));
        System.out.println("Equals : "+ (Smith01.equals(Smith02)));

        // [INSERTING]
        StringBuilder sb = new StringBuilder(s);
        sb.insert(0, "Dr. ");
        sb.delete(sb.indexOf("michael"), sb.indexOf("michael")+"michael".length());
        s = sb.toString();

        System.out.println(s);

    }

    // =========================== METHODS =========================== \\
}