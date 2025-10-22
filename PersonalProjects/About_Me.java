import java.util.Scanner;

public class About_Me {
    public static void main(String[] args) {
        Menu();
        about_me();
    }

    public static void Menu() { //This is the UI/Menu for users to select which number to choose specifically on what they want to know.
        System.out.println("\n+==========+-ABOUT-ME-+==========+");
        System.out.println("                                  ");
        System.out.println("1. Sumarry          5. Education  ");
        System.out.println("2. Contacts         6. Expertise  ");
        System.out.println("3. Language         7. Skills     ");
        System.out.println("4. Experience       8. Links      ");
        System.out.println("                                  ");
        System.out.println("+==-==-==-==-==-==-==-==-==-==-==+");
    }

    public static void about_me() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nWhat do you want to know? (Pick a number from 1-6)");
        int AboutMe = scanner.nextInt();

        switch (AboutMe) {
            case 1:
                System.out.println("\n+====================================Summary====================================+");
                System.out.println("    Motivated and responsible with strong technical skills and a proven ability");
                System.out.println("to work under pressure. Adaptable and organized, ready to contribute to team");
                System.out.println("success while applying education and enhancing organizational goals. Skilled in");
                System.out.println("software applications, problem-solving, and time management");
                System.out.println("+===============================================================================+");
                break;

            case 2: 
                System.out.println("\n==================Contacts==================");
                System.out.println("📱 Phone Number: +1(680)-287-7958");
                System.out.println("📫 Gmail: KirisutoK@Gmail.com");
                System.out.println("📧 School Email: cdampog@fingerlakes.edu");
                System.out.println("📍 Waterloo, NY 13165");
                System.out.println("============================================");
            break;

            case 3:
                System.out.println("\n========Language========");
                System.out.println("Fluent English");
                System.out.println("Tagalog");
                System.out.println("Native Tagalog");
                System.out.println("========================");
            break;

            case 4:
                System.out.println("=====================================Experience=====================================");
                System.out.println("Bella Jewellers LLC | Waterloo, NY 13165");
                System.out.println("Retail Store Associate | June 2025 - Currently working");
                System.out.println("\n◆ Set up devices (Printers, PC, & Security Cameras) and provide troubleshooting.");
                System.out.println("◆ Maintaining cleanliness environment and product.");
                System.out.println("◆ Making a website using Wix and creating promotional videos.");
                System.out.println("◆ Sales management.");
                System.out.println("◆ Greetings and assisting customers in selecting jewelry and accessories based on");
                System.out.println("  personal style.");
                System.out.println("◆ Provided product knowledge to customers about gemstones, metals, and care");
                System.out.println("  techniques.");
                System.out.println("\nLoo Brew Internship | Waterloo, NY 13165");
                System.out.println("Barista | Oct 2024 - June 2025");
                System.out.println("\n◆ Customer communication and informational assistance.");
                System.out.println("◆ Maintaining a clean environment.");
                System.out.println("◆ Prepared and served a variety of coffee beverages to customers.");
                System.out.println("◆ Maintained cleanliness and organization of the coffee bar and seating area.");
                System.out.println("◆ Assisted customers with menu selections and provided product recommendations.");
                System.out.println("◆ Handled cash transactions accurately at the point of sale system.");
                System.out.println("◆ Collaborated with team members to meet peak service demands efficiently.");
                System.out.println("◆ Engaged with customers to create a welcoming atmosphere in the café.");
                System.out.println("◆ Memorized recipes for specialty coffee beverages and seasonal offerings.");
                System.out.println("====================================================================================");
            break;

            case 5:
            break;

            case 6:
            break;

            case 7:
            break;

        }

        System.out.println("\nWould you like to know more? (Y/N)");
        char CASE1RETURN = scanner.next().charAt(0);

        if (CASE1RETURN == 'y' || CASE1RETURN == 'Y') {
            main(new String[0]);
            return;
        } else {
            System.out.println("\nThank you for your time!");
        }

        scanner.close();
    }
}
