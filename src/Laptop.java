/**
 * @author Antonio Ramos
 * Typed {@link ElectronicsItem} for laptops.
 */
public class Laptop extends ElectronicsItem {

	private boolean touchScreen;
	private boolean runningWindows;

	/**
	 * Constructs a new Laptop.
	 * @param name The name of this Laptop.
	 * @param brand The brand of this Laptop.
	 * @param price The price of this Laptop.
	 * @param description The description of this Laptop.
	 * @param returnPolicy The return policy of this Laptop.
	 * @param screenWidth The screen width of this Laptop.
	 * @param screenLength The screen length of this Laptop.
	 * @param touchScreen Whether this Laptop has touch screen.
	 * @param runningWindows Whether this Laptop is running windows.
	 */
	public Laptop(
		String name,
		String brand,
		double price,
		String description,
		String returnPolicy,
		double screenWidth,
		double screenLength,
		boolean touchScreen,
		boolean runningWindows
	) {
		super(name, brand, price, description, returnPolicy, screenWidth, screenLength);
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
	 * @param touchScreen The touch screen state to set to.
	 */
	public void setTouchScreen(boolean touchScreen) {
		this.touchScreen = touchScreen;
	}

	@Override
	public String getType() {
		return "Laptop";
	}

	@Override
	public String toVerticalString(int tabs) {
		return super.toVerticalString(tabs)
			+ withTab(tabs, "Touch Screen: " + touchScreen)
			+ withTab(tabs, "Running Windows: " + runningWindows);
	}

	@Override
	public String toString() {
		return String.format("%s, %s%s, %s%s",
			super.toString(),
			"Touch Screen: ", touchScreen,
			"Running Windows: ", runningWindows);
	}

}
