public class Product{

    private int productId;
    private String productName;
    private double price;
    private int quantityInStock;

    public Product(int productId,String productName,double price,int quantityInStock){
        this.productId=productId;
        this.productName=productName;
        this.price=price;
        this.quantityInStock=quantityInStock;
    }

    public String getProductName() {
        return productName;
    }

    public int getProductId() {
        return productId;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void displayDetails(){
        System.out.println("Product Details : ");
        System.out.println("Id : "+productId);
        System.out.println("Name : "+productName);
        System.out.println("Price : "+price);
        System.out.println("Quantity : "+quantityInStock);
    }
    
}


class Electronics extends Product{
    private String brand;
    private int warrantyPeriod;

    public Electronics(int productId,String productName,double price,int quantityInStock,String brand,int warrantyPeriod){
        super(productId,productName,price,quantityInStock);
        this.brand=brand;
        this.warrantyPeriod=warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Brand : "+brand);
        System.out.println("Warranty : "+warrantyPeriod);
    }
}

class Clothing extends Product{
    private String size;
    private String material;

    public Clothing(int productId,String productName,double price,int quantityInStock,String size,String material){
        super(productId,productName,price,quantityInStock);
        this.size=size;
        this.material=material;
    }

    public String getSize() {
        return size;
    }

    public String getMaterial() {
        return material;
    }

    @Override
    public void displayDetails(){
        super.displayDetails();
        System.out.println("Size : "+size);
        System.out.println("Material : "+material);
    }
}