/**
 * @author Luke Loeser
 * Typed {@link FoodItem} for vegetables.
 */
public class Vegetable extends FoodItem {

	private String texture;
	private String family;

	/**
	 * Constructs a new Vegetable.
	 * @param name The name of this Vegetable.
	 * @param brand The brand of this Vegetable.
	 * @param price The price of this Vegetable.
	 * @param description The description of this Vegetable.
	 * @param returnPolicy The return policy of this Vegetable.
	 * @param color The color of this Vegetable.
	 * @param taste The taste of this Vegetable.
	 * @param texture The texture of this Vegetable.
	 * @param family The family of this Vegetable.
	 */
	public Vegetable(
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
	 * @return The texture of this Vegetable.
	 */
	public String getTexture() {
		return texture;
	}

	/**
	 * @return The family of this Vegetable.
	 */
	public String getFamily() {
		return family;
	}

	/**
	 * Sets the texture of this Vegetable.
	 * @param texture The texture to set to.
	 */
	public void setTexture(String texture) {
		this.texture = texture;
	}

	/**
	 * Sets the family of this Vegetable.
	 * @param family The family to set to.
	 */
	public void setFamily(String family) {
		this.family = family;
	}

	@Override
	public String getType() {
		return "Vegetable";
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