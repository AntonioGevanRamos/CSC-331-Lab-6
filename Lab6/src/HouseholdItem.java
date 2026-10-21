/**
 * @author Lucas Horne
 * Date: 10/10/26
 * Purpose: Household Item Class
 */
public class HouseholdItem extends StoreItem1{
    //Attributes
    private String homeArea;

    //Constructor
    public HouseholdItem(String name,
                         String brand,
                         double price,
                         int stock,
                         String description,
                         String homeArea){

        super(name, brand, price, stock, description);
        this.homeArea = homeArea;
    }

    //Constructor(NO ARG)
    public HouseholdItem(){
    }

    //Accessors
    public String getHomeArea(){
        return this.homeArea;
    }

    //Mutators
    public void setHomeArea(String homeArea){
        this.homeArea = homeArea;
    }

    //Behaviors
    @Override
    public String getReturnPolicy(){
        return "This is a Household item. There is a 31 day return policy.";
    }

    @Override
    public String toString(){
        return
                String.format("%s%-5s%-15s",
                        super.toString(),
                        "Location: ", this.homeArea);
    }
}