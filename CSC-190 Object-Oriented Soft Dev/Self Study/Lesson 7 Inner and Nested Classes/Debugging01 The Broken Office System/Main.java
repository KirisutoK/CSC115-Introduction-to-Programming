// Creation Date: June 07, 2026. at 3:40 PM
// Last Modified: August 14, 2026. at  7:57 PM

// StringUtils.java
public class Main {
    public static void main(String[] args) {
        Office office = new Office("Google HQ");
        Office.Department dept = new Office.Department("Engineering");

        Office.Employee emp1 = office.new Employee("Alice", 75000);
        Office.Employee emp2 = office.new Employee("Bob", 65000);

        dept.addEmployee(emp1);
        dept.addEmployee(emp2);

        System.out.println("========== DISPLAY DEPARTMENT =========="); //... <========= ADDED
        dept.displayDepartment();
        System.out.println("========== TOTAL SALARY =========="); //... <========= ADDED
        System.out.println("Total Salary: $" + dept.calculateTotalSalary());
        System.out.println("========== OFFICE INFO =========="); //... <========= ADDED
        office.displayInfo();
        System.out.println("========== ADDRESS =========="); //... <========= ADDED
        Office.Address addr = new Office.Address("123 StringUtils St", "New York");
        addr.displayAddress();
    }
}
