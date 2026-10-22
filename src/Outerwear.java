/**
 * @author Etan Ferguson
 * Typed {@link ClothingItem} for outerwear.
 */
public class Outerwear extends ClothingItem {

	private String size;
	private boolean waterProof;
	private boolean uvProtection;

	/**
	 * Constructs a new Outerwear.
	 * @param name The name of this Outerwear.
	 * @param brand The brand of this Outerwear.
	 * @param price The price of this Outerwear.
	 * @param description The description of this Outerwear.
	 * @param returnPolicy The return policy of this Outerwear.
	 * @param genderSection The gender section of this Outerwear.
	 * @param material The material of this Outerwear.
	 * @param size The size of this Outerwear.
	 * @param waterProof Whether this Outerwear is waterproof.
	 * @param uvProtection Whether this Outerwear has UV Protection.
	 */
	public Outerwear(
		String name,
		String brand,
		double price,
		String description,
		String returnPolicy,
		String genderSection,
		String material,
		String size,
		boolean waterProof,
		boolean uvProtection
	) {
		super(name, brand, price, description, returnPolicy, genderSection, material);
		this.size = size;
		this.waterProof = waterProof;
		this.uvProtection = uvProtection;
	}

	/**
	 * @return The size of this Outerwear.
	 */
	public String getSize() {
		return size;
	}

	/**
	 * @return Whether this Outerwear is waterproof.
	 */
	public boolean isWaterProof() {
		return waterProof;
	}

	/**
	 * @return Whether this Outerwear has UV Protection.
	 */
	public boolean hasUVProtection() {
		return uvProtection;
	}

	/**
	 * Sets the size of this Outerwear.
	 * @param size The size to set to.
	 */
	public void setSize(String size) {
		this.size = size;
	}

	/**
	 * Sets whether this Outerwear is waterproof.
	 * @param waterProof The waterproof state to set to.
	 */
	public void setWaterProof(boolean waterProof) {
		this.waterProof = waterProof;
	}

	/**
	 * Sets whether this Outerwear has UV Protection.
	 * @param uvProtection The UV Protection state to set to.
	 */
	public void setUVProtection(boolean uvProtection) {
		this.uvProtection = uvProtection;
	}

	@Override
	public String toString() {
		return String.format("%s%s%-10s%n%s%-10s%n%s%-10s%n",
			super.toString(),
			"Size: ", size,
			"Waterproof: ", waterProof,
			"UV Protection: ", uvProtection);
	}

}
