public class MethodError02 {
  public static void main (String[] args) {
    
    int a = 10;
    double b = MethodError02.halfTheNumber(a);
    
    System.out.println("The new number is: " + b);
    
  }
  
  public static double halfTheNumber(int num) {
    double num1 = num / 2.0;
    return num1;
  }
  
}