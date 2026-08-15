// Creation Date: June 02, 2026. at 1:59 PM
// Last Modified: August 14, 2026. at  7:57 PM

// StringUtils.java
import Products.*;
import Store.*;

public class Main {
    public static void main(String[] args) {
        Store store = new Store("Tech Shop");

        Product p1 = new Product("Laptop", 999.99, 5);
        Product p2 = new Product("Mouse", 29.99, 20);
        DigitalProduct dp1 = new DigitalProduct("Antivirus Software", 49.99, "EXE");

        store.addProduct(p1);
        store.addProduct(p2);
        store.addProduct(dp1);

        store.displayAllProducts();

        System.out.println("Total Stock Value: $" + store.calculateTotalValue());

        store.sellProduct("Laptop", 2);
        store.sellProduct("Antivirus Software", 1);

        System.out.println("\nAfter Sales:");
        store.displayAllProducts();
        System.out.println("Total Stock Value: $" + store.calculateTotalValue());
    }
}
