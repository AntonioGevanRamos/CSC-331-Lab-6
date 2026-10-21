/**
 * Typed {@link ElectronicsItem} for a laptop.
 */
public class Laptop extends ElectronicsItem {

	private boolean touchScreen;
	private boolean runningWindows;

	/**
	 * Constructs a new Laptop.
	 * @param touchScreen The touch screen ability of this Laptop.
	 * @param runningWindows Whether this Laptop is running windows.
	 * @param screenWidth The screen width of this Laptop.
	 * @param screenLength The screen length of this Laptop.
	 * @param name The name of this Laptop.
	 * @param price The price of this Laptop.
	 * @param brand The brand of this Laptop.
	 * @param description The descritpion of this Laptop.
	 * @param returnPolicy The return policy of this Laptop/
	 */
	public Laptop(
		boolean touchScreen,
		boolean runningWindows,
		double screenWidth,
		double screenLength,
		String name,
		double price,
		String brand,
		String description,
		String returnPolicy
	) {
		super(screenWidth, screenLength, name, price, brand, description, returnPolicy, "Laptop");
		this.touchScreen = touchScreen;
		this.runningWindows = runningWindows;
	}

	/**
	 * @return Whether this Laptop is running windows.
	 */
	public boolean isRunningWindows() {
		return runningWindows;
	}

	/**
	 * @return Whether this Laptop has touch screen.
	 */
	public boolean isTouchScreen() {
		return touchScreen;
	}

	/**
	 * Sets whether this Laptop is running windows.
	 * @param runningWindows Running windows or not.
	 */
	public void setRunningWindows(boolean runningWindows) {
		this.runningWindows = runningWindows;
	}

	/**
	 * Sets whether this Laptop has touch screen.
	 * @param touchScreen The touch screen state.
	 */
	public void setTouchScreen(boolean touchScreen) {
		this.touchScreen = touchScreen;
	}

	@Override
	public String toString() {
		return String.format("%s%n%s%-10s%n%s%-10s",
			super.toString(),
			"Touch Screen: ", touchScreen,
			"Running Windows: ", runningWindows);
	}

}
