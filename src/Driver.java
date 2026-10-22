import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Driver {

	private static final List<StoreItem> inventory = new ArrayList<>();
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		populateInventory();

		boolean run = true;

		menuLoop: while (run) {
			displayMenu();
			switch (scanner.nextInt()) {
				case 1 -> populateInventory();
				case 2 -> populateInventory();
				case 3 -> {
					run = false;
					break menuLoop;
				}
				default -> System.out.print("Invalid selection.");
			}
		}
	}

	private static void displayMenu() {
		System.out.println(getHeader("Wilmington Quick Shop", 0, false));
		System.out.print("""
			1. Add an item to inventory
			2. Sell an item
			3. Exit
			
			Please enter your selection: 
			""");
	}

	private static void addToInventory() {
		System.out.println(getHeader("Adding Item(s) to Inventory", 0, false));

		boolean adding = true;
		addLoop: while (adding) {
			displayAddMenu();
			switch (scanner.nextInt()) {
				case 1 -> populateInventory();
				case 2 -> populateInventory();
				case 3 -> populateInventory();
				case 4 -> populateInventory();
				case 5 -> {
					adding = false;
					break addLoop;
				}
				default -> System.out.println("Invalid selection.");
			}
		}
	}

	private static void displayAddMenu() {
		System.out.print("""
			Select a category to add items from.
			1. Clothing
			2. Electronics
			3. Food
			4. Household
			5. Exit
			
			Please enter your selection: 
			""");
	}

	private static void addItem(String category) {

	}

	private static List<StoreItem> filterItems(List<StoreItem> items, String category) {
		List<StoreItem> selected = new ArrayList<>();
		for (StoreItem item : items) {
			boolean select = switch (category) {
				case "Clothing" -> item instanceof ClothingItem;
				case "Electronics" -> item instanceof ElectronicsItem;
				case "Food" -> item instanceof FoodItem;
				case "Household" -> item instanceof HouseholdItem;
				default -> false;
			};
			if (select)
				selected.add(item);
		}
		return selected;
	}

	private static void displayItems(List<StoreItem> items, String category) {
		if (category == null || category.isBlank()) {
			displayItems(items);
			return;
		}
		displayItems(filterItems(items, category));
	}

	private static void displayItems(List<StoreItem> items) {
		for (StoreItem item : items) {
			System.out.println(item + "\n");
		}
	}

	private static String getHeader(String headerText, int chars, boolean inline) {
		int filler;
		if (headerText.length() >= chars - 6) {
			chars = headerText.length() + 6;
			filler = 3;
		} else {
			filler = (chars - headerText.length()) / 2;
		}
		if (inline)
			return "-".repeat(filler) + headerText + "-".repeat(filler);
		return "-".repeat(chars) + "\n" + " ".repeat(filler) + headerText + " ".repeat(filler) + "\n" + "-".repeat(chars);
	}

	/**
	 * Helper method for populating inventory with types of {@link StoreItem}s.
	 */
	private static void populateInventory() {
		inventory.addAll(List.of(
			// HouseholdItems
			new CleaningSupply(
				"Bleach",
				"Clorox",
				20,
				"A chemical solution—most commonly a dilute form of sodium hypochlorite—used to whiten fabrics, remove stains, and kill germs on hard surfaces.",
				"Can not be returned after 3 days from date of purchase, or has already been unsealed.",
				"Laundry Room",
				true,
				true),
			new Furniture(
				"Couch",
				"Wayfair",
				300,
				"A cushioned, multi-seat piece of furniture designed for sitting or lounging in living rooms, dens, and offices.",
				"Can not be returned after 2 weeks from date of purchase, or has already been damaged.",
				"Living Room",
				4,
				10,
				4
			),

			// ElectronicsItems
			new Phone(
				"iPhone 18 Pro Max",
				"Apple",
				1200,
				"A short form of telephone, which is an electronic device used to talk to someone in another location using electrical wires or radio signals.",
				"Can not be returned after 1 week from date of purchase, or has already been damaged.",
				3.07,
				6.43,
				true,
				3
			),
			new Laptop(
				"Alienware 16x",
				"Alienware",
				2000,
				"A portable personal computer (PC) that combines a screen, keyboard, touchpad (mouse replacement), battery, and internal hardware into a single, foldable clamshell design.",
				"Can not be returned after 1 week from date of purchase, or has already been damaged.",
				13.57,
				8.48,
				false,
				true
			),
			new TV(
				"Quantum 4K",
				"Vizio",
				3000,
				"a telecommunication system, electronic medium, or physical device used for transmitting and displaying moving images with accompanying sound.",
				"Can not be returned after 1 week from date of purchase, or has already been damaged.",
				74.1,
				41.7,
				true,
				true
			),

			// ClothingItems
			new Outerwear(
				"US Explor QuickRidge",
				"Under Armour",
				210,
				"Clothing designed to be worn over other garments, or specifically as the outermost layer worn outdoors to provide warmth, protection from the elements, and insulation.",
				"Can not be returned after 1 week from date of purchase, or has already been damaged.",
				"Male",
				"Nylon",
				"Large",
				true,
				true
			),
			new Shoe(
				"Old Skool Shoe",
				"Vans",
				75,
				"An external item of footwear worn on the human foot to provide protection, comfort, and support against various terrains and weather conditions, typically stopping at or below the ankle.",
				"Can not be returned after 1 week from date of purchase, or has already been damaged.",
				"Male",
				"Suede",
				11,
				"Black",
				true
			),
			new Shirt(
				"Nike Club",
				"Nike",
				75,
				"A lightweight piece of clothing worn on the upper body.",
				"Can not be returned after 1 week from date of purchase, or has already been damaged.",
				"Male",
				"Cotton",
				"Large",
				"Collared Long Sleeve",
				"Mercury"
			),

			// FoodItems
			new Fruit(
				"Granny Smith",
				"Nature's Promise",
				2,
				"A round, edible pome fruit with firm white flesh and a red, yellow, or green skin that grows on the Malus domestica tree.",
				"Can not be returned.",
				"Green",
				"Sweet",
				"Firm",
				"Rose"
			),
			new Vegetable(
				"Broccoli",
				"Birds Eye",
				0.2,
				"The edible parts of herbaceous plants.",
				"Can not be returned.",
				"Green",
				"Bitter",
				"Firm",
				"Mustard"
			),
			new ShelfStable(
				"Ravioli",
				"Chef Boyardee",
				4,
				"Food that can be safely stored at room temperature (ambient temperature) in a sealed container for a long time without spoiling or requiring refrigeration or freezing.",
				"Can not be returned.",
				"Red",
				"Savory",
				"Creamy",
				2
			)
		));
	}

}
