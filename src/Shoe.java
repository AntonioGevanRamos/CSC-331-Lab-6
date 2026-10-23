/**
 * @author Etan Ferguson
 * Typed {@link ClothingItem} for shoes.
 */
public class Shoe extends ClothingItem {

	private double size;
	private String color;
	private boolean toesCovered;

	/**
	 * Constructs a new Shoe.
	 * @param name The name of this Shoe.
	 * @param brand The brand of this Shoe.
	 * @param price The price of this Shoe.
	 * @param description The description of this Shoe.
	 * @param returnPolicy The return policy of this Shoe.
	 * @param genderSection The gender section of this Shoe.
	 * @param material The material of this Shoe.
	 * @param size The size of this Shoe.
	 * @param color The color of this Shoe.
	 * @param toesCovered Whether this Shoe covers toes.
	 */
	public Shoe(
		String name,
		String brand,
		double price,
		String description,
		String returnPolicy,
		String genderSection,
		String material,
		double size,
		String color,
		boolean toesCovered
	) {
		super(name, brand, price, description, returnPolicy, genderSection, material);
		this.size = size;
		this.color = color;
		this.toesCovered = toesCovered;
	}

	/**
	 * @return The size of this Shoe.
	 */
	public double getSize() {
		return size;
	}

	/**
	 * @return The color of this Shoe.
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @return Whether the toes are covered for this Shoe.
	 */
	public boolean areToesCovered() {
		return toesCovered;
	}

	/**
	 * Sets the size of this Shoe.
	 * @param size The size to set to.
	 */
	public void setSize(double size) {
		this.size = size;
	}

	/**
	 * Sets the color of this Shoe.
	 * @param color The color to set to.
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Sets whether the toes are covered for this Shoe.
	 * @param toesCovered The toes covered state to set to.
	 */
	public void setToesCovered(boolean toesCovered) {
		this.toesCovered = toesCovered;
	}

	@Override
	public String getType() {
		return "Shoe";
	}

	@Override
	public String toVerticalString(int tabs) {
		return super.toVerticalString(tabs)
			+ withTab(tabs, "Size: " + size)
			+ withTab(tabs, "Color: " + color)
			+ withTab(tabs, "Toes Covered: " + toesCovered);
	}

	@Override
	public String toString() {
		return String.format("%s, %s%s, %s%s, %s%s",
			super.toString(),
			"Size: ", size,
			"Color: ", color,
			"Toes Covered: ", toesCovered);
	}

}
