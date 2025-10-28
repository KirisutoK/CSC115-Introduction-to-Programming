public class calculateWeeklyPay {
    public static void main(String[] args) {
        System.out.println("Weekly Pay: $" + calculatePay(20));
    }

    public static double calculatePay(double num) {
        double hourlyWage = 15.50;
        double total = 0; // Starting point for total pay

        if (num <= 20) { // No overtime
            total = num * hourlyWage;
        } else { // Overtime pay for hours worked over 20
            total = num * hourlyWage + 18.00*(num - 20);
        }
        return total; 
    }
}
