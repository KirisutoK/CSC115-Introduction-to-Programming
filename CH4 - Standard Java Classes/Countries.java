import java.util.Scanner;

public class Countries {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What is your name?");
        String NAME = scanner.nextLine();

        System.out.println("How old are you?");
        int AGE = scanner.nextInt();

        System.out.println("What country?");
        String COUNTRY = scanner.next();

        System.out.println("Hi, " + NAME + " from " + COUNTRY + ", You are " + AGE + " years old.");

        scanner.close();

        //---------------------------------------------------------------------------------------------------------//

        int DRIVINGAGE = 1;
        int VOTINGAGE = 1;
        int DRINKINGAGE = 1;
        int RUNFORPRESIDENT = 1;

        if (COUNTRY.equals("USA")) {
            DRIVINGAGE = 16;
            VOTINGAGE = 18;
            DRINKINGAGE = 21;
            RUNFORPRESIDENT = 35;
        }
        
        if (COUNTRY.equals("Japan")) {
            DRIVINGAGE = 18;
            VOTINGAGE = 12;
            DRINKINGAGE = 20;
            RUNFORPRESIDENT = 25;
        }

        if (COUNTRY.equals("Argentina")) {
            DRIVINGAGE = 17;
            VOTINGAGE = 16;
            DRINKINGAGE = 18;
            RUNFORPRESIDENT = 30;

        }

        if (AGE >= DRIVINGAGE) {
            System.out.println("You can drive");
        }
        else {
            System.out.println("You cannot drive");
        }


        if (AGE >= VOTINGAGE) {
            System.out.println("You can vote");
        }
        else {
            System.out.println("You cannot vote");
        }

        if (AGE >= DRINKINGAGE) {
            System.out.println("You can drink");
        }
        else {
            System.out.println("You cannot drink");
        }

        if (AGE >= RUNFORPRESIDENT) {
            System.out.println("You can run for president");
        }
        else {
            System.out.println("You cannot run for president");
        }


        }

}
