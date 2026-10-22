/**
 * @author Antonio Ramos
 * Typed {@link ElectronicsItem} for phones.
 */
public class Phone extends ElectronicsItem {

	private boolean hotspotActivated;
	private int cameras;

	/**
	 * Constructs a new Phone.
	 * @param name The name of this Phone.
	 * @param price The price of this Phone.
	 * @param brand The brand of this Phone.
	 * @param description The description of this Phone.
	 * @param returnPolicy The return policy of this Phone.
	 * @param screenWidth The screen width of this Phone.
	 * @param screenLength The screen length of this Phone.
	 * @param hotspotActivated The hotspot status of this Phone.
	 * @param cameras The number of cameras of this Phone.
	 */
	public Phone(
		String name,
		double price,
		String brand,
		String description,
		String returnPolicy,
		double screenWidth,
		double screenLength,
		boolean hotspotActivated,
		int cameras
	) {
		super(name, brand, price, description, returnPolicy, screenWidth, screenLength);
		this.hotspotActivated = hotspotActivated;
		this.cameras = cameras;
	}

	/**
	 * @return Whether this Phone has hotspot.
	 */
	public boolean hasHotspot() {
		return hotspotActivated;
	}

	/**
	 * @return The number of cameras of this Phone.
	 */
	public int getCameras() {
		return cameras;
	}

	/**
	 * Sets the hotspot status of this Phone.
	 * @param hotspotActivated The hotspot status to set to.
	 */
	public void setHotspot(boolean hotspotActivated) {
		this.hotspotActivated = hotspotActivated;
	}

	/**
	 * Sets the number of cameras of this Phone.
	 * @param cameras The number of cameras to set to.
	 */
	public void setCameras(int cameras) {
		this.cameras = cameras;
	}

	@Override
	public String toString() {
		return String.format("%s%n%s%-10s%n%s%-10s",
			super.toString(),
			"Hotspot: ", hotspotActivated,
			"Cameras: ", cameras);
	}

}
