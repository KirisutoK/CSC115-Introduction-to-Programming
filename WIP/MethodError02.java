public class MethodError02 {
  
  // Global Variable \\
  static double pi = Math.PI;
  public static void main (String[] args) {
    double Radius = 10;
    double b = MethodError02.halfTheNumber(Radius);
    
    System.out.println("The new number is: " + b);
  }
  
  public static double halfTheNumber(double num) {
    double Circumference = 2 * pi * num;
    return Circumference;
  }
  
}