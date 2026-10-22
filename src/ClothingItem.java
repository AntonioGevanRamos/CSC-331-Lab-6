/**
 * @author Etan Ferguson
 * Typed {@link StoreItem} for clothing items.
 */
public class ClothingItem extends StoreItem {

	private String genderSection;
	private String material;

	/**
	 * Constructs a new ClothingItem.
	 * @param name The name of this ClothingItem.
	 * @param brand The brand of this ClothingItem.
	 * @param price The price of this ClothingItem.
	 * @param description The description of this ClothingItem.
	 * @param returnPolicy The return policy of this ClothingItem.
	 * @param genderSection The gender section of this ClothingItem.
	 * @param material The material of this ClothingItem.
	 */
	public ClothingItem(
		String name,
		String brand,
		double price,
		String description,
		String returnPolicy,
		String genderSection,
		String material
	) {
		super(name, brand, price, description, returnPolicy);
		this.genderSection = genderSection;
		this.material = material;
	}

	/**
	 * @return The gender section of this ClothingItem.
	 */
	public String getGenderSection() {
		return genderSection;
	}

	/**
	 * @return The material of this ClothingItem.
	 */
	public String getMaterial() {
		return material;
	}

	/**
	 * Sets the gender section of this ClothingItem.
	 * @param genderSection The gender section to set to.
	 */
	public void setGenderSection(String genderSection) {
		this.genderSection = genderSection;
	}

	/**
	 * Sets the material of this ClothingItem.
	 * @param material The material to set to.
	 */
	public void setMaterial(String material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return String.format("%s%s%-10s%n%s%-10s%n",
			super.toString(),
			"Gender Section: ", genderSection,
			"Material: ", material);
	}

}
