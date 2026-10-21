/**
 * @author Etan Ferguson
 * @date 10/21/26
 * Purpose: Outerwear subclass of clothing item
 */

public class Outerwear extends ClothingItem{

    //Instance Variables
    private String size;
    private boolean waterProof;
    private boolean UVProtection;

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
     * @param waterProof
     * @param UVProtection
     */
    public Outerwear(String name, String brand, double price, int stock, String description,
                     String genderSection, String material,
                     String size, boolean waterProof, boolean UVProtection){

        super(name, brand, price, stock, description, genderSection, material);
        this.size = size;
        this.waterProof = waterProof;
        this.UVProtection = UVProtection;
    }

    //getters
    public String getSize() {return size;}
    public boolean isUVProtection() {return UVProtection;}
    public boolean isWaterProof() {return waterProof;}

    //setters
    public void setSize(String size) {this.size = size;}
    public void setWaterProof(boolean waterProof) {this.waterProof = waterProof;}
    public void setUVProtection(boolean UVProtection) {this.UVProtection = UVProtection;}

    @Override
    public String toString(){
        return
                String.format("%s%-10s%n%s%-10s%n%b%-10s%n%b%n",
                        super.toString(),
                        "Size: ", this.size,
                        "Water Proof: ", this.waterProof,
                        "UV Protection: ", this.UVProtection);
    }
}
