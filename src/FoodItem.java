/**
 * @author Luke Loeser
 * Typed {@link StoreItem} for food items.
 */
public class FoodItem extends StoreItem {

	private String color;
	private String taste;

	/**
	 * Constructs a new FoodItem.
	 * @param name The name of this FoodItem.
	 * @param brand The brand of this FoodItem.
	 * @param price The price of this FoodItem.
	 * @param description The description of this FoodItem.
	 * @param returnPolicy The return policy of this FoodItem.
	 * @param color The color of this FoodItem.
	 * @param taste The taste of this FoodItem.
	 */
	public FoodItem(
		String name,
		String brand,
		double price,
		String description,
		String returnPolicy,
		String color,
		String taste
	) {
		super(name, brand, price, description, returnPolicy);
		this.color = color;
		this.taste = taste;
	}

	/**
	 * @return The color of this FoodItem.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return The taste of this FoodItem.
	 */
	public String getTaste() {
		return taste;
	}

	/**
	 * Sets the color of this FoodItem.
	 * @param color The color to set to.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Sets the taste of this FoodItem.
	 * @param taste The taste to set to.
	 */
	public void setTaste(String taste) {
		this.taste = taste;
	}

	@Override
	public String toString() {
		return String.format("%s%s%-10s%n%s%-10s%n",
			super.toString(),
			"Color: ", color,
			"Taste: ", taste);
	}

}
