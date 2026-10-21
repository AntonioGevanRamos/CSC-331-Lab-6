/**
 * @author Lucas Horne
 * Date: 10/10/26
 * Purpose: Create Store Item Class
 */
public class StoreItem{
    //Atttributes
    private String name;
    private double price;
    private String brand;
    private String description;
    private String returnPolicy;
    //private String type;

    //Constructor
    /**
     *
     * @param name
     * @param price
     * @param brand
     * @param description
     * @param returnPolicy
     */
    public StoreItem(String name,
                     double price,
                     String brand,
                     String description,
                     String returnPolicy){
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.returnPolicy = returnPolicy;
        //this.type = type;
    }

    //Constructor(NO ARG)
    /**
     *
     */
    public StoreItem(){
        this.name = "None";
        this.price = 0;
        this.brand = "None";
        this.description = "None";
        this.returnPolicy = "None";
        //this.type = "None";
    }

    @Override
    public String toString() {
        return String.format("%s%n%-36s%36s%n%-36s%32s%3.2f%n%-36s%36s%n%-36s%36s%n%-36s%36s%n",
                "---------------------------------------------------------------------------------------",
                "Name:", this.getName(),
                "Price:", "$ ", this.getPrice(),
                "Brand:", this.getBrand(),
                "Description:", this.getDescription(),
                "Return Policy:", this.getReturnPolicy());
    }

    //Accessors
    public String getName(){
        return this.name;
    }

    public double getPrice(){
        return this.price;
    }

    public String getBrand(){
        return this.brand;
    }

    public String getDescription(){
        return this.description;
    }

    public String getReturnPolicy(){
        return this.returnPolicy;
    }

    //public String getType(){
        //return this.type;
    //}

    //Mutators
    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setBrand(String brand){
        this.brand = brand;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setReturnPolicy(String returnPolicy){
        this.returnPolicy = returnPolicy;
    }

    //public void setType(String type){
        //this.type = type;
    //}

    //Behaviors
    //N/A
}
