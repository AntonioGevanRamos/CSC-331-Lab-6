/**initialzies fruit as a subclass of fooditem*/
public class Fruit extends foodItem {
    protected String texture;
    protected String family;

    /**fruit constructor with all paramters*/
    public Fruit(String texture, String family,
                 String color, String taste,
                 String name, String brand, double price, int stock, String description){
        super(color, taste, name, brand, price, stock, description);
        this.texture = texture;
        this.family = family;
    }

    /**fruit constructor with no paramters*/
    public Fruit(){
    }

    @Override
    /**Formats what fruit's print output is, overrides the toString method, an example of polymorphism*/
    public String toString(){
        return
                String.format("%s%s%-10s%n%s%-10s%n",
                        super.toString(),
                        "Texture: ", this.texture,
                        "Family: ", this.family);
    }

    /**getters*/
     String getTexture(){
        return this.texture;
    }

    public String getFamily(){
        return this.family;
    }

    /**setters*/

    public void setTexture(String texture){
        this.texture = texture;
    }

    public void setFamily(String family){
        this.family = family;
    }
}

