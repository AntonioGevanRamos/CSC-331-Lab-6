/**initialzies vegetable as a subclass of fooditem*/
public class Vegetable extends foodItem{
    protected String texture;
    protected String family;

    /**vegetable constructor with all paramters*/
    public Vegetable(String texture, String family,
                 String color, String taste,
                 String name, String brand, double price, int stock, String description){
        super(color, taste, name, brand, price, stock, description);
        this.texture = texture;
        this.family = family;
    }

    /**vegetable constructor with no paramters*/
    public Vegetable(){
    }

    @Override
    public String toString(){
        return
                String.format("%s%s%-10s%n%s%-10s%n",
                        super.toString(),
                        "texture: ", this.texture,
                        "family: ", this.family);
    }

    /**gettas*/

    public String getTexture(){
        return this.texture;
    }

    public String getFamily(){
        return this.family;
    }

    /**settas*/

    public void setTexture(String texture){
        this.texture = texture;
    }

    public void setFamily(String family){
        this.family = family;
    }
}
