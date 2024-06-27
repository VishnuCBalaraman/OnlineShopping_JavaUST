
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class DuplicateProductIDException extends Exception{
    public DuplicateProductIDException(String message){
        super(message);
    }
}

class ProductNotFoundException extends Exception{
    public ProductNotFoundException(String message){
        super(message);
    }
}


public class ShoppingCart {
    private List<Product> cart;

    public ShoppingCart(){
        this.cart = new ArrayList<>();
    }

    public void addproduct(Product product) throws DuplicateProductIDException{
        for(Product p: cart){
            if(p.getProductId()==product.getProductId()){
                throw new DuplicateProductIDException("Duplicate Product");
            }
        }
        cart.add(product);
    }

    public void deleteproduct(int id) throws ProductNotFoundException{
        Product producttoremove=null;
        for(Product p : cart){
            if(p.getProductId()==id){
                producttoremove = p;
                break;
            }
        }
        if(producttoremove==null){
            throw new ProductNotFoundException("Product with corresponding id doesn't exist");
        }
        cart.remove(producttoremove);
    }

    public void displaycart(){
        for(Product p : cart){
            p.displayDetails();
            System.out.println();
        }
    }

    public void caltotalprice(){
        double tp=0;
        for(Product p: cart){
            tp+=p.getPrice();
        }
        System.out.println("Total Price : "+tp);
    }


    public static void main(String args[]){
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Electronics");
            System.out.println("2. Add Clothing");
            System.out.println("3. Display Cart");
            System.out.println("4. Calculate Total Price");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter product name: ");
                        String electronicsName = scanner.nextLine();
                        System.out.print("Enter product ID: ");
                        int electronicsId = scanner.nextInt();
                        System.out.print("Enter price: ");
                        double electronicsPrice = scanner.nextDouble();
                        System.out.print("Enter quantity in stock: ");
                        int electronicsQuantity = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter brand: ");
                        String brand = scanner.nextLine();
                        System.out.print("Enter warranty period: ");
                        int warrantyPeriod = scanner.nextInt();

                        Electronics electronics = new Electronics(electronicsId,electronicsName, electronicsPrice, electronicsQuantity, brand, warrantyPeriod);
                        cart.addproduct(electronics);
                        break;

                    case 2:
                        System.out.print("Enter product name: ");
                        String clothingName = scanner.nextLine();
                        System.out.print("Enter product ID: ");
                        int clothingId = scanner.nextInt();
                        System.out.print("Enter price: ");
                        double clothingPrice = scanner.nextDouble();
                        System.out.print("Enter quantity in stock: ");
                        int clothingQuantity = scanner.nextInt();
                        scanner.nextLine(); 
                        System.out.print("Enter size: ");
                        String size = scanner.nextLine();
                        System.out.print("Enter material: ");
                        String material = scanner.nextLine();

                        Clothing clothing = new Clothing(clothingId,clothingName, clothingPrice, clothingQuantity, size, material);
                        cart.addproduct(clothing);
                        break;

                    case 3:
                        cart.displaycart();
                        break;

                    case 4:
                        cart.caltotalprice();
                        break;

                    case 5:
                        System.out.print("Enter product ID to delete: ");
                        int deleteId = scanner.nextInt();
                        cart.deleteproduct(deleteId);
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (DuplicateProductIDException | ProductNotFoundException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
