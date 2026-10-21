/**
 * @author Etan Ferguson
 * @date 10/21/26
 * Purpose: Shoes subclass of Clothing Item
 */

public class Shoes extends ClothingItem{

    // Instance Variables
    private double size;
    private String color;
    private boolean toesCovered;


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
     * @param color
     * @param toesCovered
     */
    public Shoes(String name, String brand, double price, int stock, String description, String genderSection,
                 String material, double size, String color, boolean toesCovered){

        super(name, brand, price, stock, description, genderSection, material);
        this.size = size;
        this.color = color;
        this.toesCovered = toesCovered;
    }

    //getters
    public double getSize(){return size;}
    public String getColor(){return color;}
    public boolean getToesCovered(){return toesCovered;}

    //setters
    public void setSize(double size){this.size = size;}
    public void setColor(String color){this.color = color;}
    public void setToesCovered(boolean toesCovered){this.toesCovered = toesCovered;}

    @Override
    public String toString(){
        return
                String.format("%s%-10d%s%n%-10s%s%n%-10s%b%n",
                        super.toString(),
                        "Size: ", this.size,
                        "Color: ", this.color,
                        "Exposed Toes: ", this.toesCovered);
    }






}
