
public class CleaningSupply extends HouseholdItem {
	//Attributes
    private boolean isBottled;
    private boolean isToxic;

    //Constructor

    /**
     *
     * @param name
     * @param brand
     * @param price
     * @param stock
     * @param description
     * @param homeArea
     * @param isBottled
     * @param isToxic
     */
    public CleaningSupply(String name,
                          String brand,
                          double price,
                          int stock,
                          String description,
                          String homeArea,
                          boolean isBottled,
                          boolean isToxic){

        super(name, brand, price, stock, description, homeArea);
        this.isBottled = isBottled;
        this.isToxic = isToxic;
    }

    //Constructor(NO ARG)

    /**
     *
     */
    public CleaningSupply(){
    }

    //Accessors
    public boolean getisBottled(){
        return this.isBottled;
    }

    public boolean getisToxic(){
        return this.isToxic;
    }

    //Mutators
    public void setisBottled(boolean isBottled){
        this.isBottled = isBottled;
    }

    public void setisToxic(boolean isToxic){
        this.isToxic = isToxic;
    }

    //Behaviors
    @Override
    public String toString(){
        return
                String.format("%s%-5s%-12b%n%-5s%-10b%n",
                        super.toString(),
                        "Bottled: ", this.isBottled,
                        "Toxic: ", this.isToxic);
    }
}
