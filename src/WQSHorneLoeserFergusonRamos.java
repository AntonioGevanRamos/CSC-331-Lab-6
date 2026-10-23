/**
 * @authors Lucas Horne, Luke Loeser, Etan Ferguson, Antonio Ramos
 * Date: 10/10/26
 * Purpose: Driver File for Store Front
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WQSHorneLoeserFergusonRamos {

	//create array and scanner
	private static List<QuantifiedItem> inventory = new ArrayList<>();
	private static Scanner scanner = new Scanner(System.in);
	
	/**
	* Main method for handling the main menu, and hands off to addMenu or sellMenu depending on user input.
	*/
	public static void main(String[] args) {
		populateInventory();
		boolean run = true; // Emergency control statement for exiting while loop

		// Continuously displays main menu to user until they exit.
		menuLoop: while (run) {
			// Displays the main menu to user
			displayMenu();
			// Handles user input
			switch (scanner.nextInt()) {
				case 1 -> addMenu();
				case 2 -> sellMenu();
				case 3 -> { // Exits
					run = false; // Set emergency control statement to false
					break menuLoop;
				}
				default -> System.out.print("Invalid selection.");
			}
		}
	}

	/**
	 * Helper method for displaying the main menu in console.
	 * Informs user of the available options to choose from.
	 */
	private static void displayMenu() {
		System.out.println("\n" + getHeader("Wilmington Quick Shop", 0, false));
		System.out.print("""
			1. Add an item to inventory
			2. Sell an item
			3. Exit
			
			""");
		System.out.print("Please enter your selection: ");
	}
	
	/**
	* Menu handler for adding items to inventory, prompts user for category and hands off to addItem.
	*/
	private static void addMenu() {
		boolean adding = true; // Emergency control statement for exiting while loop
		// Continuously displays add menu to user until they exit.
		addLoop: while (adding) {
			// Displays the add menu to user
			displayAddMenu();
			// Handles user input
			switch (scanner.nextInt()) {
				// 1 -> 4, calls addItem with the corresponding category
				case 1 -> addItem("clothing");
				case 2 -> addItem("electronics");
				case 3 -> addItem("food");
				case 4 -> addItem("household");
				case 5 -> {
					adding = false; // Set emergency control statement to false
					break addLoop;
				}
				default -> System.out.println("Invalid selection.");
			}
		}
	}

	/**
	 * Helper method for displaying the add menu in console.
	 * Informs user of the available options to choose from.
	 */
	private static void displayAddMenu() {
		System.out.println("\n" + getHeader("Adding Item(s) to Inventory", 0, false));
		System.out.print("""
			Select a category to add items from.
			1. Clothing
			2. Electronics
			3. Food
			4. Household
			5. Exit
			
			""");
		System.out.print("Please enter your selection: ");
	}

	/**
	 * Displays current items in inventory that are in the provided category.
	 * Prompts user to choose an existing item from inventory or create a new item of the provided category and the amount they want to add.
	 * Items are added in inventory.
	 * @param category The category to filter by for existing items in inventory and creating a new item.
	 */
	private static void addItem(String category) {
		boolean adding = true; // Emergency control statement for exiting while loop
		// Continuously displays add item menu to user until they exit.
		while (adding) {
			// Display the current inventory for the selected category.
			System.out.println("\n" + getHeader("Current inventory for " + category.toLowerCase(), 0, false));

			// Filter inventory for items in the provided category
			List<QuantifiedItem> items = filterItems(inventory, category);
			displayItems(items, false);
			System.out.println();

			// Dynamic indices for creating a new item or exiting
			int createIndex = items.size() + 1;
			int returnIndex = createIndex + 1;

			// Build dynamic menu
			String output = "Select a product to add\n";
			for (int i = 0; i < items.size(); i++) {
				QuantifiedItem item = items.get(i);
				output += (i + 1) + ". " + item.toSimpleString() + "\n";
			}
			output += createIndex + ". Create new " + category.toLowerCase() + " item\n";
			output += returnIndex + ". Exit\n\n";
			output += "Please enter your selection: ";
			System.out.print(output);
			QuantifiedItem selectedItem = null;
			int selection = scanner.nextInt();

			// Selected option is invalid
			if (selection < 1 || selection > returnIndex) {
				System.out.println("Invalid selection");
				continue;

			} else if (selection < createIndex) {
				// Retrieves the item the user wishes to add more of
				selectedItem = items.get(selection - 1);
			} else if (selection == createIndex) {
				// Retrieves the item the user creates
				StoreItem storeItem = createItem(category);
				// If the created item was null, return back to addMenu
				if (storeItem == null)
					return;
				selectedItem = new QuantifiedItem(storeItem);
				inventory.add(selectedItem);
			} else if (selection == returnIndex) {
				// User chooses to exit, goes back to addMenu
				adding = false;
				break;
			}
			// No item was selected or created, rerun loop
			if (selectedItem == null)
				continue;
			// Increase the selected item's quantity by the amount entered.
			System.out.print("Enter quantity to add: ");
			int quantity = scanner.nextInt();
			selectedItem.addQuantity(quantity);
		}
	}

	/**
	 * Handler for creating new items depending on the provided category.
	 * @param category The category to create a new item in.
	 * @return The newly created item.
	 */
	private static StoreItem createItem(String category) {
		// Get types as choices from category
		String[] choices;
		if (category.equalsIgnoreCase("clothing")) {
			choices = new String[]{"Outerwear", "Shirt", "Shoe"};
		} else if (category.equalsIgnoreCase("electronics")) {
			choices = new String[]{"Laptop", "Phone", "TV"};
		} else if (category.equalsIgnoreCase("food")) {
			choices = new String[]{"Fruit", "Shelf Stable", "Vegetable"};
		} else {
			choices = new String[]{"Cleaning Supply", "Furniture"};
		}

		// Dynamic index for exiting
		int returnIndex = choices.length + 1;

		// Build dynamic menu
		String output = "Select an item to create from\n";
		for (int i = 0; i < choices.length; i++) {
			String choice = choices[i];
			output += (i + 1) + ". " + choice + "\n";
		}
		output += returnIndex + ". Exit\n\n";
		output += "Please enter your selection: ";
		System.out.print(output);

		// Get user input
		int selection = scanner.nextInt();
		if (selection < 1 || selection > returnIndex) { // Invalid input
			System.out.print("Invalid selection");
			return null;
		}
		// Get the type the user wishes to create
		String selectedChoice = choices[selection - 1];
		StoreItem item = null;
		scanner.nextLine();

		// Prompting user for data for item, starting off at root super StoreItem
		System.out.print("Enter name of item: ");
		String name = scanner.nextLine();
		System.out.print("Enter brand of item: ");
		String brand = scanner.nextLine();
		System.out.print("Enter price of item: ");
		double price = scanner.nextDouble();
		scanner.nextLine();
		System.out.print("Enter description of item: ");
		String description = scanner.nextLine();
		System.out.print("Enter return policy of item: ");
		String returnPolicy = scanner.nextLine();

		// Prompts users for extra data for item depending on category and type chosen. Then creates the item.
		switch (category) {
			case "clothing" -> { // Prompting user for data for item for ClothingItem
				System.out.print("Enter gender section of item: ");
				String genderSection = scanner.nextLine();
				System.out.print("Enter material of item: ");
				String material = scanner.nextLine();
				switch (selectedChoice) {
					case "Outerwear" -> { // Prompting user for data for item for Outerwear
						System.out.print("Enter size of item: ");
						String size = scanner.nextLine();
						System.out.print("Enter waterproof state of item (true/false): ");
						boolean waterproof = scanner.nextBoolean();
						System.out.print("Enter UV Protection state of item (true/false): ");
						boolean uvProtection = scanner.nextBoolean();
						item = new Outerwear(name, brand, price, description, returnPolicy, genderSection, material, size, waterproof, uvProtection);
					}
					case "Shirt" -> { // Prompting user for data for item for Shirt
						System.out.print("Enter size of item: ");
						String size = scanner.nextLine();
						System.out.print("Enter shirt type of item: ");
						String shirtType = scanner.nextLine();
						System.out.print("Enter color of item: ");
						String color = scanner.nextLine();
						item = new Shirt(name, brand, price, description, returnPolicy, genderSection, material, size, shirtType, color);
					}
					case "Shoe" -> { // Prompting user for data for item for Shoe
						System.out.print("Enter size of item: ");
						int size = scanner.nextInt();
						System.out.print("Enter color of item: ");
						String color = scanner.nextLine();
						System.out.print("Enter toes covered state of item (true/false): ");
						boolean toesCovered = scanner.nextBoolean();
						item = new Shoe(name, brand, price, description, returnPolicy, genderSection, material, size, color, toesCovered);
					}
				}
			}
			case "electronics" -> { // Prompting user for data for item for ElectronicsItem
				System.out.print("Enter screen width of item (in.): ");
				double screenWidth = scanner.nextDouble();
				System.out.print("Enter screen length of item (in.): ");
				double screenLength = scanner.nextDouble();
				switch (selectedChoice) {
					case "Laptop" -> { // Prompting user for data for item for Laptop
						System.out.print("Enter touch screen state of item (true/false): ");
						boolean touchScreen = scanner.nextBoolean();
						System.out.print("Enter running windows state of item (true/false): ");
						boolean runningWindows = scanner.nextBoolean();
						item = new Laptop(name, brand, price, description, returnPolicy, screenWidth, screenLength, touchScreen, runningWindows);
					}
					case "Phone" -> { // Prompting user for data for item for Phone
						System.out.print("Enter hotspot state of item (true/false): ");
						boolean hotspotActivated = scanner.nextBoolean();
						System.out.print("Enter cameras of item: ");
						int cameras = scanner.nextInt();
						item = new Phone(name, brand, price, description, returnPolicy, screenWidth, screenLength, hotspotActivated, cameras);
					}
					case "TV" -> { // Prompting user for data for item for TV
						System.out.print("Enter smart TV state of item (true/false): ");
						boolean smartTV = scanner.nextBoolean();
						System.out.print("Enter cable state of item (true/false): ");
						boolean cable = scanner.nextBoolean();
						return new TV(name, brand, price, description, returnPolicy, screenWidth, screenLength, smartTV, cable);
					}
				}
			}
			case "food" -> { // Prompting user for data for item for FoodItem
				System.out.print("Enter color of item: ");
				String color = scanner.nextLine();
				System.out.print("Enter taste of item: ");
				String taste = scanner.nextLine();
				switch (selectedChoice) {
					case "Fruit" -> { // Prompting user for data for item for Fruit
						System.out.print("Enter texture of item: ");
						String texture = scanner.nextLine();
						System.out.print("Enter family of item: ");
						String family = scanner.nextLine();
						item = new Fruit(name, brand, price, description, returnPolicy, color, taste, texture, family);
					}
					case "Shelf Stable" -> { // Prompting user for data for item for ShelfStable
						System.out.print("Enter texture of item: ");
						String texture = scanner.nextLine();
						System.out.print("Enter shelf life of item (years): ");
						int shelfLife = scanner.nextInt();
						item = new ShelfStable(name, brand, price, description, returnPolicy, color, taste, texture, shelfLife);
					}
					case "Vegetable" -> { // Prompting user for data for item for Vegetable
						System.out.print("Enter texture of item: ");
						String texture = scanner.nextLine();
						System.out.print("Enter family of item: ");
						String family = scanner.nextLine();
						item = new Vegetable(name, brand, price, description, returnPolicy, color, taste, texture, family);
					}
				}
			}
			case "household" -> { // Prompting user for data for item for HouseholdItem
				System.out.print("Enter home area of item: ");
				String homeArea = scanner.nextLine();
				switch (selectedChoice) {
					case "Cleaning Supply" -> { // Prompting user for data for item for CleaningSupply
						System.out.print("Enter bottled state of item (true/false): ");
						boolean bottled = scanner.nextBoolean();
						System.out.print("Enter toxic state of item (true/false): ");
						boolean toxic = scanner.nextBoolean();
						item = new CleaningSupply(name, brand, price, description, returnPolicy, homeArea, bottled, toxic);
					}
					case "Furniture" -> { // Prompting user for data for item for Furniture
						System.out.print("Enter height of item (ft): ");
						double height = scanner.nextDouble();
						System.out.print("Enter width of item (ft): ");
						double width = scanner.nextDouble();
						System.out.print("Enter depth of item (ft): ");
						double depth = scanner.nextDouble();
						item = new Furniture(name, brand, price, description, returnPolicy, homeArea, height, width, depth);
					}
				}
			}
		}
		return item; // Returns the newly created item
	}

	/**
	 * Menu handler for selling items from inventory, prompts user for category and hands off to sellItem with the cart.
	 */
	private static void sellMenu() {
		boolean selling = true; // Emergency control statement for exiting while loop

		// Creates a backup of inventory incase user cancels checkout
		List<QuantifiedItem> inventoryBackup = new ArrayList<>();
		for (QuantifiedItem item : inventory) {
			inventoryBackup.add(new QuantifiedItem(item.getStoreItem(), item.getQuantity()));
		}

		// Storage for items user wishes to purchase
		List<QuantifiedItem> cart = new ArrayList<>();

		// Continuously displays sell menu to user until they exit.
		sellLoop: while (selling) {
			displaySellMenu();
			
			// Handles user input
			switch (scanner.nextInt()) {
				// 1 -> 4, calls sellItem with the corresponding category and the current cart
				case 1 -> sellItem("clothing", cart);
				case 2 -> sellItem("electronics", cart);
				case 3 -> sellItem("food", cart);
				case 4 -> sellItem("household", cart);
				case 5 -> { // Displays the items currently in the cart
					System.out.println("\n" + getHeader("Cart", 20, false));
					displayItems(cart, true);
				}
				case 6 -> { // Hands off to confirmCheckout for if the user is done
					if (confirmCheckout(cart)) { // Only stop if user confirms
						selling = false; // Set emergency control statement to false
						break sellLoop;
					}
				}
				case 7 -> { // User wishes to cancel, empty cart and load inventory backup
					selling = false; // Set emergency control statement to false
					inventory = inventoryBackup;
					break sellLoop;
				}
			}
		}
	}

	/**
	 * Displays current items in inventory that are in the provided category.
	 * Prompts user to choose an item to purchase and the amount.
	 * @param category The category to filter by for purchasing items in inventory.
	 * @param cart The current cart of this checkout
	 */
	private static void sellItem(String category, List<QuantifiedItem> cart) {
		boolean selling = true; // Emergency control statement for exiting while loop
		// Continuously displays sell item menu to user until they exit.
		while (selling) {
			System.out.println("\n" + getHeader("Current inventory for " + category.toLowerCase(), 0, false));

			// Filter inventory for items in the provided category
			List<QuantifiedItem> items = filterItems(inventory, category);

			// Dynamic index for exiting
			int returnIndex = items.size() + 1;

			// Builds dynamic menu to display items in inventory with their data, their index, and the stock
			System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-100s %-30s%n",
				"Option", "Stock", "Type", "Name", "Brand", "Price ($)", "Description", "Return Policy");
			for (int i = 0; i < items.size(); i++) {
				QuantifiedItem item = items.get(i);
				StoreItem storeItem = item.getStoreItem();
				System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10.2f %-100s %-30s%n",
					(i + 1) + ".", item.getQuantity() + "x", storeItem.getType(), storeItem.getName(),
					storeItem.getBrand(), storeItem.getPrice(), storeItem.getDescription(), storeItem.getReturnPolicy());
			}
			System.out.println(returnIndex + ". Exit\n");
			System.out.print("Please enter your selection: ");

			int selection = scanner.nextInt();

			// Selected option was invalid
			if (selection < 1 || selection > returnIndex) {
				System.out.println("Invalid selection");
				continue;
			} 
			else if (selection == returnIndex) { // Exit
				selling = false;
				return;
			}

			// Retrieves item based on the option the user selected
			QuantifiedItem item = items.get(selection - 1);

			// Prompts user for quantity they wish to purchase
			System.out.print("Please enter quantity: ");
			int quantity = scanner.nextInt();
			if (quantity > item.getQuantity()) { // Provided quantity is more than stock
				System.out.println("There is only " + item.getQuantity() + "x of this item in stock.");
				continue;
			}

			// Adds the item to the cart with they amount they wish to purchase
			QuantifiedItem cartItem = new QuantifiedItem(item.getStoreItem(), quantity);
			item.subQuantity(quantity);
			// If remaining stock in inventory is 0, remove from inventory
			if (item.getQuantity() <= 0)
				inventory.remove(item);
			// add item to cart
			addToCart(cart, cartItem);
		}
	}

	/**
	 * Adds the provided item to the cart, by merging the item if it already exists in the cart, otherwise adds.
	 * @param cart The current cart.
	 * @param item The item to add or merge.
	 */
	private static void addToCart(List<QuantifiedItem> cart, QuantifiedItem item) {
		for (QuantifiedItem cartItem : cart) {
			if (cartItem == item) {
				cartItem.addQuantity(item.getQuantity());
				return;
			}
		}
		cart.add(item);
	}

	/**
	 * Helper method for displaying the sell menu in console.
	 * Informs user of the available options to choose from.
	 */
	private static void displaySellMenu() {
		System.out.println("\n" + getHeader("Purchasing Item(s)", 0, false));
		System.out.print("""
			Select a category to purchase items from.
			1. Clothing
			2. Electronics
			3. Food
			4. Household
			5. View Cart
			6. Checkout
			7. Exit (Cart Emptied)
			
			""");
		System.out.print("Please enter your selection: ");
	}

	/**
	 * Prompts user if they wish to confirm or cancel checkout. Displays items in the cart.
	 * @param cart The current cart.
	 * @return true if the user confirmed, otherwise false.
	 */
	private static boolean confirmCheckout(List<QuantifiedItem> cart) {
		System.out.println("\n" + getHeader("Confirm Checkout", 0, false));
		displayItems(cart, true);
		// Displays total cost of all items in cart with their tax rate.
		double total = 0;
		for (QuantifiedItem item : cart) {
			StoreItem storeItem = item.getStoreItem();
			double price = storeItem.getPrice();
			price += price * storeItem.getTaxRate();
			total += price;
		}
		System.out.println("Total: $" + String.format("%.2f", total) + "\n");
		System.out.println("""
			1. Confirm Checkout
			2. Cancel
			""");
		System.out.print("Please enter your selection: ");
		int selection = scanner.nextInt();

		// Selected option was invalid
		if (selection < 1 || selection > 2) {
			System.out.println("Invalid selection");
			return false;
		} else if (selection == 1) { // User confirmed checkout, hands off to checkout
			checkout(cart);
			return true;
		}
		// User canceled checkout, return to sellMenu
		return false;
	}

	/**
	 * User confirmed checkout, display remaining inventory and return policies of all items bought.
	 * @param cart The items the user purchased.
	 */
	private static void checkout(List<QuantifiedItem> cart) {
		System.out.println("\n" + getHeader("Inventory", 0, false));
		displayItems(inventory, false);
		System.out.println("\n" + getHeader("Return Policies", 0, false));
		for (QuantifiedItem item : cart) {
			StoreItem storeItem = item.getStoreItem();
			System.out.println(" - " + storeItem.toSimpleString() + " - " + storeItem.getReturnPolicy());
		}
	}

	/**
	 * Filters the provided items by the provided category.
	 * @param items The items.
	 * @param category The category to filter by.
	 * @return The filtered items.
	 */
	private static List<QuantifiedItem> filterItems(List<QuantifiedItem> items, String category) {
		List<QuantifiedItem> selected = new ArrayList<>();
		for (QuantifiedItem item : items) {
			StoreItem storeItem = item.getStoreItem();
			boolean select = switch (category) {
				case "clothing" -> storeItem instanceof ClothingItem;
				case "electronics" -> storeItem instanceof ElectronicsItem;
				case "food" -> storeItem instanceof FoodItem;
				case "household" -> storeItem instanceof HouseholdItem;
				default -> false;
			};
			if (select)
				selected.add(item);
		}
		return selected;
	}

	/**
	 * Displays items to console.
	 * @param items The items to display.
	 * @param vertical Whether the items should be displayed vertically or horizontally.
	 */
	private static void displayItems(List<QuantifiedItem> items, boolean vertical) {
		if (vertical) {
			for (QuantifiedItem item : items) {
				System.out.println(item.toVerticalString(1));
			}
		} else {
			for (QuantifiedItem item : items) {
				System.out.println(item);
			}
		}
	}

	/**
	 * Helper method for creating a header to print out in console.
	 * @param headerText The header text.
	 * @param chars The number of characters the line(s) should be. Raised if less than header text.
	 * @param inline Whether the header text should be inlined in the header, or on its own line.
	 * @return The header.
	 */
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
		List<StoreItem> items = List.of(
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
		);

		for (StoreItem storeItem : items) {
			inventory.add(new QuantifiedItem(storeItem));
		}
	}

}
