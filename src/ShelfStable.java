/**initialzies shelfStable as a subclass of fooditem*/
public class shelfStable extends foodItem{
    protected String texture;
    protected int shelfLife;

    /**shelfStable constructor with all paramters*/
    public shelfStable(String texture, int shelfLife,
                     String color, String taste,
                     String name, String brand, double price, int stock, String description){
        super(color, taste, name, brand, price, stock, description);
        this.texture = texture;
        this.shelfLife = shelfLife;
    }

    /**shelfStabe constructor with no parameters*/
    public shelfStable(){
    }

    /**Formats what vegetable's print output is, overrides the toString method, an example of polymorphism*/
    @Override
    public String toString () {
        return String.format("%s%s%-10s%n%s%-10d%n",
                super.toString(), "Texture:",
                this.getTexture(), "Shelf Life:",
                this.shelfLife, " years");
    }

    /**gettas*/

    public String getTexture(){
        return this.texture;
    }

    public int getShelfLife(){
        return this.shelfLife;
    }

    /**settas*/

    public void setTexture(String texture){
        this.texture = texture;
    }

    public void setShelfLife(int shelfLife){
        this.shelfLife = shelfLife;
    }
}

