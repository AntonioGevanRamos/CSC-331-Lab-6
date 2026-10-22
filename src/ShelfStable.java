/**
 * @author Luke Loeser
 * Typed {@link FoodItem} for shelf stable.
 */
public class ShelfStable extends FoodItem {

	private String texture;
	private int shelfLife;

	/**
	 * Constructs a new ShelfStable.
	 * @param name The name of this ShelfStable.
	 * @param brand The brand of this ShelfStable.
	 * @param price The price of this ShelfStable.
	 * @param description The description of this ShelfStable.
	 * @param returnPolicy The return policy of this ShelfStable.
	 * @param color The color of this ShelfStable.
	 * @param taste The taste of this ShelfStable.
	 * @param texture The texture of this ShelfStable.
	 * @param shelfLife The shelf life of this ShelfStable.
	 */
	public ShelfStable(
		String name,
		String brand,
		double price,
		String description,
		String returnPolicy,
		String color,
		String taste,
		String texture,
		int shelfLife
	) {
		super(name, brand, price, description, returnPolicy, color, taste);
		this.texture = texture;
		this.shelfLife = shelfLife;
	}

	/**
	 * @return The texture of this ShelfStable.
	 */
	public String getTexture() {
		return texture;
	}

	/**
	 * @return The shelf life of this ShelfStable.
	 */
	public int getShelfLife() {
		return shelfLife;
	}

	/**
	 * Sets the texture of this ShelfStable.
	 * @param texture The texture to set to.
	 */
	public void setTexture(String texture) {
		this.texture = texture;
	}

	/**
	 * Sets the shelf life of this ShelfStable.
	 * @param shelfLife The shelf life to set to.
	 */
	public void setShelfLife(int shelfLife) {
		this.shelfLife = shelfLife;
	}

	@Override
	public String toString() {
		return String.format("%s%s%-10s%n%s%-10s%n",
			super.toString(),
			"Texture: ", texture,
			"Shelf Life (Years): ", shelfLife);
	}

}
