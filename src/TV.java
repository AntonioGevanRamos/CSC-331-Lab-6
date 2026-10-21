/**
 * Typed {@link ElectronicsItem} for a television.
 */
public class TV extends ElectronicsItem {

	private boolean smartTV;
	private boolean cable;

	/**
	 * Constructs a new TV.
	 * @param smartTV Whether this TV is a smartTV.
	 * @param cable Whether this TV has cable.
	 * @param screenWidth The screen width of this TV.
	 * @param screenLength The screen length of this TV.
	 * @param name The name of this TV.
	 * @param price The price of this TV.
	 * @param brand The brand of this TV.
	 * @param description The description of this TV.
	 * @param returnPolicy The return policy of this TV.
	 */
	public TV(
		boolean smartTV,
		boolean cable,
		double screenWidth,
		double screenLength,
		String name,
		double price,
		String brand,
		String description,
		String returnPolicy
	) {
		super(screenWidth, screenLength, name, price, brand, description, returnPolicy, "TV");
		this.smartTV = smartTV;
		this.cable = cable;
	}

	/**
	 * @return Whether this TV is a smart tv.
	 */
	public boolean isSmartTV() {
		return smartTV;
	}

	/**
	 * @return Whether this TV has cable.
	 */
	public boolean hasCable() {
		return cable;
	}

	/**
	 * Sets whether this TV is a smart tv.
	 * @param smartTV The smart tv status to set to.
	 */
	public void setSmartTV(boolean smartTV) {
		this.smartTV = smartTV;
	}

	/**
	 * Sets whether this TV has cable.
	 * @param cable The cable status to set to.
	 */
	public void setCable(boolean cable) {
		this.cable = cable;
	}

	@Override
	public String toString() {
		return String.format("%s%n%s%-10s%n%s%-10s",
			super.toString(),
			"Smart TV: ", smartTV,
			"Cable: ", cable);
	}

}
