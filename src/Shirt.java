/**
 * @author Etan Ferguson
 * Typed {@link ClothingItem} for shirts.
 */
public class Shirt extends ClothingItem {

	private String size;
	private String shirtType;
	private String color;

	/**
	 * Constructs a new Shirt.
	 * @param name The name of this Shirt.
	 * @param brand The brand of this Shirt.
	 * @param price The price of this Shirt.
	 * @param description The description of this Shirt.
	 * @param returnPolicy The return policy of this Shirt.
	 * @param genderSection The gender section of this Shirt.
	 * @param material The material of this Shirt.
	 * @param size The size of this Shirt.
	 * @param shirtType The shirt type of this Shirt.
	 * @param color The color of this Shirt.
	 */
	public Shirt(
		String name,
		String brand,
		double price,
		String description,
		String returnPolicy,
		String genderSection,
		String material,
		String size,
		String shirtType,
		String color
	) {
		super(name, brand, price, description, returnPolicy, genderSection, material);
		this.size = size;
		this.shirtType = shirtType;
		this.color = color;
	}

	/**
	 * @return The size of this Shirt.
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @return The shirt type of this Shirt.
	 */
	public String getShirtType() {
		return shirtType;
	}

	/**
	 * @return The color of this Shirt.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Sets the size of this Shirt.
	 * @param size The size to set to.
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Sets the shirt type of this Shirt.
	 * @param shirtType The shirt type to set to.
	 */
	public void setShirtType(String shirtType) {
		this.shirtType = shirtType;
	}

	/**
	 * Sets the color of this Shirt.
	 * @param color The color to set to.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return String.format("%s%s%-10s%n%s%-10s%n%s%-10s%n",
			super.toString(),
			"Size: ", size,
			"Shirt Type: ", shirtType,
			"Color: ", color);
	}

}
