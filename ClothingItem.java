/**
 * @author Etan Ferguson
 * Date: 10/19/26
 * Purpose: Create Clothing Item Class
 */

public class ClothingItem extends StoreItem{

    //instance variables
    private String genderSection;
    private String material;

    // Constructor

    /**
     *
     * @param name
     * @param brand
     * @param price
     * @param stock
     * @param description
     * @param genderSection
     * @param material
     */
    public ClothingItem(String name, String brand, double price, int stock, String description,
                        String genderSection, String material){
        super(name, brand, price, stock, description);
        this.genderSection = genderSection;
        this.material = material;

    }

    // Getters
    public String getGenderSection() {return genderSection;}
    public String getMaterial() {return material;}

    // Setters
    public void setGenderSection(String genderSection) {this.genderSection = genderSection;}
    public void setMaterial (String material) {this.material = material;}

    @Override
    public String toString(){
        return
                String.format("%s%-10s%s%n%-10s%s%n",
                        super.toString(),
                        "Gender Section: ", this.genderSection,
                        "Material: ", this.material);
    }
}
