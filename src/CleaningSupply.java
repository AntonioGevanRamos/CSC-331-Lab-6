/**
 * @author Lucas Horne
 * Typed {@link HouseholdItem} for cleaning supplies.
 */
public class CleaningSupply extends HouseholdItem {

	private boolean bottled;
	private boolean toxic;

	/**
	 * Constructs a new CleaningSupply.
	 * @param name The name of this CleaningSupply.
	 * @param brand The brand of this CleaningSupply.
	 * @param price The price of this CleaningSupply.
	 * @param description The description of this CleaningSupply.
	 * @param returnPolicy The return policy of this CleaningSupply.
	 * @param homeArea The home area of this CleaningSupply.
	 * @param bottled Whether this CleaningSupply is bottled.
	 * @param toxic Whether this CleaningSupply is toxic.
	 */
	public CleaningSupply(
		String name,
		String brand,
		double price,
		String description,
		String returnPolicy,
		String homeArea,
		boolean bottled,
		boolean toxic
	) {
		super(name, brand, price, description, homeArea, returnPolicy);
		this.bottled = bottled;
		this.toxic = toxic;
	}

	/**
	 * @return Whether this CleaningSupply is bottled.
	 */
	public boolean isBottled() {
		return bottled;
	}

	/**
	 * @return Whether this CleaningSupply is toxic.
	 */
	public boolean isToxic() {
		return toxic;
	}

	/**
	 * Set whether this CleaningSupply is bottled.
	 * @param bottled The bottled state to set to.
	 */
	public void setBottled(boolean bottled) {
		this.bottled = bottled;
	}

	/**
	 * Set whether this CleaningSupply is toxic.
	 * @param toxic The toxic state to set to.
	 */
	public void setToxic(boolean toxic) {
		this.toxic = toxic;
	}

	@Override
	public String toString() {
		return String.format("%s%s%-10s%n%s%-10s%n",
			super.toString(),
			"Bottled: ", bottled,
			"Toxic: ", toxic);
	}

}
