/**
 * @author Luke Loeser
 * Typed {@link FoodItem} for fruit.
 */
public class Fruit extends FoodItem {

	private String texture;
	private String family;

	/**
	 * Constructs a new Fruit.
	 * @param name The name of this Fruit.
	 * @param brand The brand of this Fruit.
	 * @param price The price of this Fruit.
	 * @param description The description of this Fruit.
	 * @param returnPolicy The return policy of this Fruit.
	 * @param color The color of this Fruit.
	 * @param taste The taste of this Fruit.
	 * @param texture The texture of this Fruit.
	 * @param family The family of this Fruit.
	 */
	public Fruit(
		String name,
		String brand,
		double price,
		String description,
		String returnPolicy,
		String color,
		String taste,
		String texture,
		String family
	) {
		super(name, brand, price, description, returnPolicy, color, taste);
		this.texture = texture;
		this.family = family;
	}

	/**
	 * @return The texture of this Fruit.
	 */
	public String getTexture() {
		return texture;
	}

	/**
	 * @return The family of this Fruit.
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * Sets the texture of this Fruit.
	 * @param texture The texture to set to.
	 */
	public void setTexture(String texture) {
		this.texture = texture;
	}

	/**
	 * Sets the family of this Fruit.
	 * @param family The family to set to.
	 */
	public void setFamily(String family) {
		this.family = family;
	}

	@Override
	public String getType() {
		return "Fruit";
	}

	@Override
	public String toVerticalString(int tabs) {
		return super.toVerticalString(tabs)
			+ withTab(tabs, "Texture: " + texture)
			+ withTab(tabs, "Family: " + family);
	}

	@Override
	public String toString() {
		return String.format("%s, %s%s, %s%s",
			super.toString(),
			"Texture: ", texture,
			"Family: ", family);
	}

}
