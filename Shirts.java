/**
 * @author Etan Ferguson
 * @date 10/21/26
 * Purpose: Shirts subclass of clothing item
 */

public class Shirts extends ClothingItem{

    // Instance variables
    private String size;
    private String shirtType;
    private String color;

    //Constructor

    /**
     *
     * @param name
     * @param brand
     * @param price
     * @param stock
     * @param description
     * @param genderSection
     * @param material
     * @param size
     * @param shirtType
     * @param color
     */
    public Shirts(String name, String brand, double price, int stock, String description,
                  String genderSection, String material, String size, String shirtType,
                  String color){

        super(name, brand, price, stock, description, genderSection, material);
        this.size = size;
        this.shirtType = shirtType;
        this.color = color;
    }

    //Getters
    public String getSize(){return size;}
    public String getShirtType(){return shirtType;}
    public String getColor(){return color;}

    //Setters
    public void setSize(String size){this.size = size;}
    public void setShirtType(String shirtType){this.shirtType = shirtType;}
    public void setColor(String color){this.color = color;}

    //Behaviors
    @Override
    public String toString(){
        return
                String.format("%s%-10s%s%n%-10s%s%n%-10s%s%n",
                        super.toString(),
                        "Size: ", this.size,
                        "Type of Shirt: ", this.shirtType,
                        "Color: ", this.color
                );
    }

}
