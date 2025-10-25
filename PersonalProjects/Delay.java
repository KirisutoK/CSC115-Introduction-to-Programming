//This code is about delaying a print statement

public class Delay {
    public static void main(String[] args) {
        System.out.println("Task started");

        try {
            Thread.sleep(3000);
            System.out.println("Test 1");
            Thread.sleep(3000);
            System.out.println("6 Seconds had passed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task completed after 3 seconds delay");
    }
}
