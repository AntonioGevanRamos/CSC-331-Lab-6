/**
 * @author Antonio Ramos
 * Class representing a {@link StoreItem} with x amount.
 */
public class QuantifiedItem {

	private StoreItem storeItem;
	private int quantity;

	/**
	 * Constructs a new QuantifiedItem.
	 * @param storeItem The store item of this QuantifiedItem.
	 */
	public QuantifiedItem(StoreItem storeItem) {
		this(storeItem, 1);
	}

	/**
	 * Constructs a new QuantifiedItem.
	 * @param storeItem The store item of this QuantifiedItem.
	 * @param quantity The quantity of the store item of this QuantifiedItem.
	 */
	public QuantifiedItem(StoreItem storeItem, int quantity) {
		this.storeItem = storeItem;
		this.quantity = quantity;
	}

	/**
	 * @return The store item of this QuantifiedItem.
	 */
	public StoreItem getStoreItem() {
		return storeItem;
	}

	/**
	 * @return The quantity of the store item of this QuantifiedItem.
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity of the store item of this QuantifiedItem.
	 * @param quantity The quantity to set to.
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Adds to the quantity of the store item of this QuantifiedItem.
	 * @param quantity The quantity to add.
	 */
	public void addQuantity(int quantity) {
		this.quantity += quantity;
	}

	/**
	 * Subtracts the quantity of the store item of this QuantifiedItem.
	 * @param quantity The quantity to subtract.
	 */
	public void subQuantity(int quantity) {
		this.quantity -= quantity;
	}

	/**
	 * @return The simple string of the store item.
	 */
	public String toSimpleString() {
		return storeItem.toSimpleString();
	}

	/**
	 * Gets the string representation of this QuantifiedItem indented by provided number of tabs and spread vertically for each attribute of store item.
	 * @param tabs The number of tabs to indent by.
	 * @return The vertical indented string representation.
	 */
	public String toVerticalString(int tabs) {
		return quantity + "x of " + storeItem.getType() + "\n" + storeItem.toVerticalString(tabs);
	}

	@Override
	public String toString() {
		return quantity + "x of " + storeItem.getType() + " { " + storeItem.toString() + " }";
	}

}
