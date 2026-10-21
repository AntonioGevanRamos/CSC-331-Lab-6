public class Furniture extends HouseholdItem {
	//Attributes
    private double height;
    private double width;
    private double depth;

    //Constructor

    /**
     *
     * @param name
     * @param brand
     * @param price
     * @param stock
     * @param description
     * @param homeArea
     * @param height
     * @param width
     * @param depth
     */
    public Furniture(String name,
                     String brand,
                     double price,
                     int stock,
                     String description,
                     String homeArea,
                     double height,
                     double width,
                     double depth){

        super(name, brand, price, stock, description, homeArea);
        this.height = height;
        this.width = width;
        this.depth = depth;
    }

    //Constructor(NO ARG)

    /**
     *
     */
    public Furniture(){}

    //Accessors
    public double getHeight(){
        return this.height;
    }
    public double getWidth(){
        return this.width;
    }
    public double getDepth(){
        return this.depth;
    }

    //Mutators
    public void setHeight(double height){
        this.height = height;
    }

    public void setWidth(double width){
        this.width = width;
    }

    public void setDepth(double depth){
        this.depth = depth;
    }

    //Behaviors
    @Override
    public String toString(){
        return
                String.format("%s%-5s%-9.2f%n%-5s%-9.2f%n%-5s%-7.2f%n",
                        super.toString(),
                        "Height(ft): ", this.height,
                        "Width(ft): ", this.width,
                        "Depth(ft): ", this.depth);
    }
}
