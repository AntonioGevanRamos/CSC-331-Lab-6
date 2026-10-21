public class nuclearBomb extends StoreItem1{

    public nuclearBomb(String name,String brand, double price, int stock, String description) {
        super(name, brand, price, stock, description);
    }

    @Override
    public String toString() {
        return String.format ("%s%n",
                    super.toString());
        }
    }
