import java.util.Scanner;

public class About_Me {
    public static void main(String[]args){
        System.out.println("============ABOUT ME============");
        System.out.println("                                ");
        System.out.println("1. Sumarry        5. Education  ");
        System.out.println("2. Skills         6. Expertise  ");
        System.out.println("3. Language                     ");
        System.out.println("4. Experience                   ");

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nPick a Number:");
        int AboutMe = scanner.nextInt();

        switch(AboutMe) {
            case 1:
                Method1();
            break;
        }

        scanner.close();
    }
    
    public static void Method1() {
        System.out.println("\nMotivated and responsible with strong technical skills and a proven ability to");
        System.out.println("work under pressure. Adaptable and organized, ready to contribute to team success"); 
        System.out.println("while applying education and enhancing organizational goals. Skilled in software");
        System.out.println("applications, problem-solving, and time management.");
    }
}
