import java.util.Random;
import java.util.Scanner;

public class test {
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();
    public static void main(String[] args) {
        int RandomEndNumber = random.nextInt(3)+1;
        System.out.println(RandomEndNumber);
    }
}
