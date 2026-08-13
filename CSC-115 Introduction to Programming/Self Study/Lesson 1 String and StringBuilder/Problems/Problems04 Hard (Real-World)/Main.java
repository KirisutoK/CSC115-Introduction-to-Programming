// Creation Date: August 13, 2026. at 6:40 PM
// Last Modified: August 13, 2026. at  7:04 PM

public class Main {
    // =========================== CLASS VARIABLES =========================== \\

    // =========================== MAIN =========================== \\
    public static void main(String[] args) {
        System.out.println(formatCSV("2026-08-13,ERROR,UserService,Failed to authenticate user 'jsmith',401"));
        System.out.println(formatCSV("2026-08-13,WARN,NetworkService,Failed to connect: timeout, retrying,401"));
    }

    // =========================== METHODS =========================== \\
    public static String formatCSV(String s) {
        s = s.trim();

        String[] Lines = s.split(",");

        StringBuilder sb = new StringBuilder();

        for (int i = 3; i < Lines.length-1; i++) {
            sb.append(Lines[i].trim()+(( i != Lines.length-2) ? ", ":""));
        }

        return "["+Lines[0]+"] "+Lines[1]+" ("+Lines[Lines.length-1]+") from "+Lines[2]+": "+sb;
    }
}
