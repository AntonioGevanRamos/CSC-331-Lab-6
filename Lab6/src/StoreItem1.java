/**
 * @author Lucas Horne
 * Date: 10/10/26
 * Purpose: Create Store Item Class
 */
public class StoreItem1{
    //Atttributes
    private String name;
    private String brand;
    private double price;
    private int stock;
    private String description;
    private int cartCount;

    //Constructor

    /**
     *
     * @param name
     * @param brand
     */
    public StoreItem1(String name,
                     String brand,
                     double price,
                     int stock,
                     String description){

        this.name = name;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
        this.description = description;
    }

    //Constructor(NO ARG)

    /**
     *
     */
    public StoreItem1(){
    }

    //Accessors
    public String getName(){
        return this.name;
    }

    public String getBrand(){
        return this.brand;
    }

    public double getPrice(){
        return this.price;
    }

    public int getStock(){
        return this.stock;
    }

    public String getDescription(){
        return this.description;
    }

    public int getCartCount(){
        return this.cartCount;
    }

    //Mutators
    public void setName(String name){
        this.name = name;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setStock(int stock){
        this.stock = stock;
    }

    public void setDescription(String stock){ this.description = description; }

    public void setCartCount(int cartCount){
        this.cartCount = cartCount;
    }

    //Behaviors
    public double getTaxRate(){
        return 0.07;
    }

    public String getReturnPolicy(){
        return "Just return it whenever bro.";
    }

    @Override
    public String toString(){
        return
        String.format("%s%-10s%n%s%-10s%n%s%-10.2f%n%s%-10s%n%s%-10s%n",
                "Name: ", this.name,
                "Brand: ", this.brand,
                "Price: $", this.price,
                "Stock: ", this.stock,
                "Description: ", this.description);
    }
}
