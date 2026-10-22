/**
 * @author Antonio Ramos
 * Typed {@link StoreItem} for electronic items.
 */
public class ElectronicsItem extends StoreItem {

	private double screenWidth;
	private double screenLength;

	/**
	 * Constructs a new ElectronicsItem.
	 * @param name The name of this ElectronicsItem.
	 * @param brand The brand of this ElectronicsItem.
	 * @param price The price of this ElectronicsItem.
	 * @param description The description of this ElectronicsItem.
	 * @param returnPolicy The return policy of this ElectronicsItem.
	 * @param screenWidth The width of this ElectronicsItem.
	 * @param screenLength The length of this ElectronicsItem.
	 */
	public ElectronicsItem(
		String name,
		String brand,
		double price,
		String description,
		String returnPolicy,
		double screenWidth,
		double screenLength
	) {
		super(name, brand, price, description, returnPolicy);
		this.screenWidth = screenWidth;
		this.screenLength = screenLength;
	}

	/**
	 * @return The screen width of this ElectronicsItem.
	 */
	public double getScreenWidth() {
		return screenWidth;
	}

	/**
	 * @return The screen length of this ElectronicsItem.
	 */
	public double getScreenLength() {
		return screenLength;
	}

	/**
	 * Sets the screen width of this ElectronicsItem.
	 * @param screenWidth The screen width.
	 */
	public void setScreenWidth(double screenWidth) {
		this.screenWidth = screenWidth;
	}

	/**
	 * Sets the screen length of this ElectronicsItem.
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
