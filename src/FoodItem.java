/**initialzies fooditem as a subclass of storeitem*/
public class foodItem extends StoreItem1{
    protected String color;
    protected String taste;

    /**foodItem constructor with all paramters*/
    public foodItem(String color, String taste,
                    String name, String brand, double price, int stock, String description){
        super(name, brand, price, stock, description);
        this.color = color;
        this.taste = taste;
    }

    /**shelfStabe constructor with no parameters*/
    public foodItem(){
    }

    /**Formats what fruit's print output is, overrides the toString method, an example of polymorphism*/
    @Override
    public String toString(){
        return
                String.format("%s%s%-10s%n%s%-10s%n",
                        super.toString(),
                        "Color: ", this.color,
                        "taste: ", this.taste);
    }

    /**gettas*/
    public String getColor(){
     return this.color;
     }

     public String getTaste(){
     return this.taste;
     }

    /**settas*/
    public void setColor(String color){
     this.color = color;
     }

     public void setTaste(String shape){
     this.taste = taste;
     }
}

