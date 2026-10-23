/**
 * @author Lucas Horne
 * Typed {@link StoreItem} for household items.
 */
public class HouseholdItem extends StoreItem {

	private String homeArea;

	/**
	 * Constructs a new HouseholdItem.
	 * @param name The name of this HouseholdItem.
	 * @param brand The brand of this HouseholdItem.
	 * @param price The price of this HouseholdItem.
	 * @param description The description of this HouseholdItem.
	 * @param returnPolicy The return policy of this HouseholdItem.
	 * @param homeArea The home area of this HouseholdItem.
	 */
	public HouseholdItem(
		String name,
		String brand,
		double price,
		String description,
		String returnPolicy,
		String homeArea
	) {
		super(name, brand, price, description, returnPolicy);
		this.homeArea = homeArea;
	}

	/**
	 * @return The home area of this HouseholdItem.
	 */
	public String getHomeArea() {
		return homeArea;
	}

	/**
	 * Sets the home area of this HouseholdItem.
	 * @param homeArea The home area to set to.
	 */
	public void setHomeArea(String homeArea) {
		this.homeArea = homeArea;
	}

	@Override
	public String toVerticalString(int tabs) {
		return super.toVerticalString(tabs)
			+ withTab(tabs, "Home Area: " + homeArea);
	}

	@Override
	public String toString() {
		return String.format("%s, %s%s",
			super.toString(),
			"Home Area: ", homeArea);
	}

}