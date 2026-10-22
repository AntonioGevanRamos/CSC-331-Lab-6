/**
 * @author Lucas Horne
 * Date: 10/10/26
 * Purpose: Create Store Item Class
 */
public class StoreItem{

	private String name;
	private String brand;
	private double price;
	private String description;
	private String returnPolicy;

	/**
	 * Constructs a new StoreItem
	 * @param name The name of this StoreItem.
	 * @param brand The brand of this StoreItem.
	 * @param price The price of this StoreItem.
	 * @param description The description of this StoreItem.
	 * @param returnPolicy The return policy of this StoreItem.
	 */
	public StoreItem(
		String name,
		String brand,
		double price,
		String description,
		String returnPolicy
	) {
		this.name = name;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.returnPolicy = returnPolicy;
	}

	/**
	 * @return The name of this StoreItem.
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @return The brand of this StoreItem.
	 */
	public String getBrand() {
		return this.brand;
	}

	/**
	 * @return The price of this StoreItem.
	 */
	public double getPrice() {
		return this.price;
	}

	/**
	 * @return The description of this StoreItem.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return The return policy of this StoreItem.
	 */
	public String getReturnPolicy() {
		return returnPolicy;
	}

	/**
	 * Sets the name of this StoreItem.
	 * @param name The name to set to.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the brand of this StoreItem.
	 * @param brand The brand to set to.
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Sets the price of this StoreItem.
	 * @param price The price to set to.
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Sets the description of this StoreItem.
	 * @param description The description to set to.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Sets the return policy of this StoreItem.
	 * @param returnPolicy The return policy to set to.
	 */
	public void setReturnPolicy(String returnPolicy) {
		this.returnPolicy = returnPolicy;
	}

	/**
	 * @return The tax rate of this StoreItem.
	 */
	public double getTaxRate() {
		return 0.07;
	}

	/**
	 * @return The string representation of the class.
	 */
	public String getType() {
		return "";
	}

	/**
	 * @return A simple string representation of this StoreItem.
	 */
	public final String toSimpleString() {
		return String.format("$%.2f %s %s", price, brand, name);
	}

	/**
	 * Helper method for applying tabs to the beginning of a string.
	 * @param tabs The number of tabs to appply.
	 * @param string The string to apply the tabs to.
	 * @return The string with tabs.
	 */
	public final String withTab(int tabs, String string) {
		return "\t".repeat(tabs) + string + "\n";
	}

	/**
	 * Gets the string representation of this StoreItem spread vertically for each attribute.
	 * @return The vertical string representation.
	 */
	public final String toVerticalString() {
		return toVerticalString(0);
	}

	/**
	 * Gets the string representation of this StoreItem indented by provided number of tabs and spread vertically for each attribute.
	 * @param tabs The number of tabs to indent by.
	 * @return The vertical indented string representation.
	 */
	public String toVerticalString(int tabs) {
		return withTab(tabs, "Name: " + name)
			+ withTab(tabs, "Brand: " + brand)
			+ withTab(tabs, "Price: $" + String.format("%.2f", price))
			+ withTab(tabs, "Description: " + description)
			+ withTab(tabs, "Return Policy: " + returnPolicy);
	}

	@Override
	public String toString() {
		return String.format("%s%s, %s%s, %s%.2f, %s%s, %s%s",
				"Name: ", name,
				"Brand: ", brand,
				"Price: $", price,
				"Description: ", description,
				"Return Policy: ", returnPolicy);
	}

}
