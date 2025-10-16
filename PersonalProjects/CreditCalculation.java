import java.util.Scanner;

public class CreditCalculation {
    public static void main(String[]args){
        //Put your credit hours here per semester and then click the play button (>) from your upper right screen.
        CreditCalculation();

    }

    public static void CreditCalculation(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your total 2025 Fall Credit Hours:");
        int Fall2025CreditsHrs = scanner.nextInt();

        System.out.println("Enter your total 2026 Spring Credit Hours:");
        int Spring2026CreditsHrs = scanner.nextInt();

        System.out.println("Enter your total 2026 Fall Credit Hours:");
        int Fall2026CreditsHrs = scanner.nextInt();

        System.out.println("Enter your total 2027 Spring Credit Hours:");
        int Spring2027CreditsHrs = scanner.nextInt();

        int TotalCreditHours = Fall2025CreditsHrs + Spring2026CreditsHrs + Fall2026CreditsHrs + Spring2027CreditsHrs;

        if (TotalCreditHours >=60){
            System.out.println("Eligible for an Assosiciate!");
        }
        else{
            System.out.println("Your Total Credits is " + TotalCreditHours + " , You need more credit hours!");
        }
    }
}