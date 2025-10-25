//This code is about loops. the code will run until the choosen range. kinda works like while

public class Loops {
    public static void main(String[] args) {
        try {
            for (int i = 1; i <= 5; i++) {
                Thread.sleep(1000);
                System.out.print(".");
            } 
        } catch (InterruptedException e) {
                System.out.print("DELAY ERROR!");
            }
    }
}
