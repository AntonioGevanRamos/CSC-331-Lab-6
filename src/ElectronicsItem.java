/**
 * Typed {@link StoreItem} for electronic items.
 */
public class ElectronicsItem extends StoreItem {

	private double screenWidth;
	private double screenLength;

	/**
	 * Constructs a new ElectronicsItem
	 * @param screenWidth The width of this Electronic.
	 * @param screenLength The length of this Electronic.
	 * @param name The name of this Electronic.
	 * @param price The price of this Electronic.
	 * @param brand The brand of this Electronic.
	 * @param description The description of this Electronic.
	 * @param returnPolicy The return policy of this Electronic.
	 * @param type The type of this Electronic.
	 */
	public ElectronicsItem(
		double screenWidth,
		double screenLength,
		String name,
		double price,
		String brand,
		String description,
		String returnPolicy,
		String type
	) {
		super(name, price, brand, description, returnPolicy, type);
		this.screenWidth = screenWidth;
		this.screenLength = screenLength;
	}

	/**
	 * @return The screen width of this Electronic.
	 */
	public double getScreenWidth() {
		return screenWidth;
	}

	/**
	 * @return The screen length of this Electronic.
	 */
	public double getScreenLength() {
		return screenLength;
	}

	/**
	 * Sets the screen width of this Electronic.
	 * @param screenWidth The screen width.
	 */
	public void setScreenWidth(double screenWidth) {
		this.screenWidth = screenWidth;
	}

	/**
	 * Sets the screen length of this Electronic.
	 * @param screenLength The screen length.
	 */
	public void setScreenLength(double screenLength) {
		this.screenLength = screenLength;
	}

	@Override
	public String toString() {
		return String.format("%s%n%s%-10s%n%s%-10s",
			super.toString(),
			"Screen Width: ", screenWidth,
			"Screen Length: ", screenLength);
	}

}
