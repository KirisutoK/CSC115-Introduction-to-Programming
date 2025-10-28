// try to enable to use the Thread.sleep() method
// for to find the letters in a string (its a loop method)

public class LoadingText {
    public static void main (String[] args) {
        String Title = "LOADING. . . . .";
        try { 
            for (char c : Title.toCharArray()) {
                System.out.print(c);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            System.out.println("An error occurred during loading.");
        }
    }
}

