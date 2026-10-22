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

	@Override
	public String toString() {
		return
		String.format("%-5s%-10s%-5s%-10s%-5s%-10s%-5s%-10.2f%-5s%-5d",
				"Name: ", this.name,
				"Brand: ", this.brand,
				"Price: $", this.price,
				"Stock: ", this.stock);
	}

}
