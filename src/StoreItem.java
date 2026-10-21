/**
 * @author Lucas Horne
 * Date: 10/10/26
 * Purpose: Create Store Item Class
 */
public class StoreItem{
    //Atttributes
    private String name;
    private String ID;
    private String brand;
    private double price;
    private int stock;

    //Constructor

    /**
     *
     * @param name
     * @param ID
     * @param brand
     */
    public StoreItem(String name,
                     String ID,
                     String brand,
                     double price,
                     int stock){

        this.name = name;
        this.ID = ID;
        this.brand = brand;
        this.price = price;
        this.stock = stock;
    }

    //Constructor(NO ARG)

    /**
     *
     */
    public StoreItem(){
    }

    //Accessors
    public String getName(){
        return this.name;
    }

    public String getID(){
        return this.ID;
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

    //Mutators
    public void setName(String name){
        this.name = name;
    }

    public void setID(String ID){
        this.ID = ID;
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
        String.format("%-5s%-10s%-5s%-10s%-5s%-10s%-5s%-10.2f%-5s%-5d",
                "Name: ", this.name,
                "ID: ", this.ID,
                "Brand: ", this.brand,
                "Price: $", this.price,
                "Stock: ", this.stock);
    }
}
