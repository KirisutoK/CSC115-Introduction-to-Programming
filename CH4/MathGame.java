import java.util.Scanner;

public class MathGame {
    public static void main(String[] args) {
        // practiceMath();
        practiceString();
    }

    //  public static void practiceMath() {
    //      System.out.println(Math.max(7, 10));
    //      System.out.println(Math.min(7, 10));
    //      System.out.println(Math.pow(5, 10));
    //      System.out.println(Math.round(5.1231212124));
    //      System.out.println(Math.random()*33);
    //  }

      public static void practiceString() {
          String username = "Christ Aerjil Dampog";
          String password = "FLCC123456789";
          System.out.println(password.length());
          System.out.println(username.charAt(0));
          System.out.println(username.charAt(9));
          System.out.println(username.indexOf("C"));
          System.out.println(username.indexOf("A"));
          System.out.println(username.indexOf("D"));

          Scanner scanner = new Scanner(System.in);

          System.out.println("Enter your Password");
          String response = scanner.nextLine();
          System.out.println(response.equals(password));

          String drink = "Apple Cider";
          System.out.println(drink.substring(0,5));
          System.out.println(drink.substring(6, 11));
          System.out.println(drink.substring(0));

          scanner.close();
      }

}