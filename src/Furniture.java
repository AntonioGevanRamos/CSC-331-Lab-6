/**
 * @author Lucas Horne
 * Typed {@link HouseholdItem} for furniture.
 */
public class Furniture extends HouseholdItem {

    private double height;
    private double width;
    private double depth;

	/**
	 * Constructs a new Furniture.
	 * @param name The name of this Furniture.
	 * @param brand The brand of this Furniture.
	 * @param price The price of this Furniture.
	 * @param description The description of this Furniture.
	 * @param returnPolicy The return policy of this Furniture.
	 * @param homeArea The home area of this Furniture.
	 * @param height The height of this Furniture.
	 * @param width The width of this Furniture.
	 * @param depth The depth of this Furniture.
	 */
	public Furniture(
		String name,
		String brand,
		double price,
		String description,
		String returnPolicy,
		String homeArea,
		double height,
		double width,
		double depth
	) {
		super(name, brand, price, description, returnPolicy, homeArea);
		this.height = height;
		this.width = width;
		this.depth = depth;
	}

	/**
	 * @return The height of this Furniture.
	 */
	public double getHeight() {
		return height;
	}

	/**
	 * @return The width of this Furniture.
	 */
	public double getWidth() {
		return width;
	}

	/**
	 * @return The depth of this Furniture.
	 */
	public double getDepth() {
		return depth;
	}

	/**
	 * Sets the height of this Furniture.
	 * @param height The height to set to.
	 */
	public void setHeight(double height) {
		this.height = height;
	}

	/**
	 * Sets the width of this Furniture.
	 * @param width The width to set to.
	 */
	public void setWidth(double width) {
		this.width = width;
	}

	/**
	 * Sets the depth of this Furniture.
	 * @param depth The depth to set to.
	 */
	public void setDepth(double depth) {
		this.depth = depth;
	}

	@Override
	public String toString() {
		return String.format("%s%s%-10s%n%s%-10s%n%s%-10s%n",
			super.toString(),
			"Height (ft): ", height,
			"Width (ft): ", width,
			"Depth (ft): ", depth);
	}

}
