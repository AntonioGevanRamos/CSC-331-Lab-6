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
	* main function to operate store simulation
	*/
	public static void main(String[] args) {
		
		populateInventory();

		boolean run = true; //for while loop

		//display menu and ask user to add to menu or sell
		menuLoop: while (run) {
			displayMenu();
			switch (scanner.nextInt()) {
				case 1 -> addMenu();
				case 2 -> sellMenu();
				case 3 -> {
					run = false;
					break menuLoop;
				}
				default -> System.out.print("Invalid selection.");
			}
		}
	}
	
	/**
	* displayMenu method to format menu for user to choose from
	* returns nothing
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
	* addMenu method to call choices for adding to the menu
	*/
	private static void addMenu() {
		
		boolean adding = true;
		addLoop: while (adding) {
			//what user sees
			displayAddMenu();
			//get user choice
			switch (scanner.nextInt()) {
				case 1 -> addItem("clothing");
				case 2 -> addItem("electronics");
				case 3 -> addItem("food");
				case 4 -> addItem("household");
				case 5 -> {
					adding = false;
					break addLoop;
				}
				default -> System.out.println("Invalid selection.");
			}
		}
	}
	/**
	* displayAddMenu() method is what user sees when calling addMenu()
	* returns nothing
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
	 * Lets the user add quantities to existing inventory items or create a new
	 * item in the specified category. Repeats until the user selects Exit.
	 *
	 * @param category the category of items to display and create
	 */
	private static void addItem(String category) {

		//display menu until false
		boolean adding = true;
		while (adding) {
			// Display the current inventory for the selected category.
			System.out.println("\n" + getHeader("Current inventory for " + category.toLowerCase(), 0, false));

			//create list of items from inventory
			List<QuantifiedItem> items = filterItems(inventory, category);
			displayItems(items, false);
			System.out.println();

			// Place the Create and Exit options after the existing items.
			int createIndex = items.size() + 1;
			int returnindex = createIndex + 1;
			String output = "Select a product to add\n";
			// build a numbered menu of items already in the list
			for (int i = 0; i < items.size(); i++) {
				QuantifiedItem item = items.get(i);
				output += (i + 1) + ". " + item.toSimpleString() + "\n";
			}

			output += createIndex + ". Create new " + category.toLowerCase() + " item\n";
			output += returnindex + ". Exit\n\n";
			output += "Please enter your selection: ";
			System.out.print(output);
			QuantifiedItem selectedItem = null;
			int selection = scanner.nextInt();

			// restart selection if outside the range
			if (selection < 1 || selection > returnindex) {
				System.out.println("Invalid selection");
				continue;

			} else if (selection < createIndex) {
				// convert menu to an index
				selectedItem = items.get(selection - 1);
			} else if (selection == createIndex) {
				//create an item and add it to the inventory
				StoreItem storeItem = createItem(category);
				// Leave this method if no item was created.
				if (storeItem == null)
					return;
				selectedItem = new QuantifiedItem(storeItem);
				inventory.add(selectedItem);
			} else if (selection == returnindex) {
				adding = false;
				break;
			}
			// Skip the quantity prompt if no item was selected.
			if (selectedItem == null)
				continue;
			// Increase the selected item's quantity by the amount entered.
			System.out.print("Enter quantity to add: ");
			int quantity = scanner.nextInt();
			selectedItem.addQuantity(quantity);
		}
	}
	
	/**
	* createItem method used to create a new item type in the store
	* @param category
	* returns StoreItem
	*/
	private static StoreItem createItem(String category) {
		

		// Get item category as choice
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

		// get selection
		int returnIndex = choices.length + 1;
		String output = "Select an item to create from\n";
		for (int i = 0; i < choices.length; i++) {
			String choice = choices[i];
			output += (i + 1) + ". " + choice + "\n";
		}
		//check selection validity
		output += returnIndex + ". Exit\n\n";
		output += "Please enter your selection: ";
		System.out.print(output);
		int selection = scanner.nextInt();
		if (selection < 1 || selection > returnIndex) {
			System.out.print("Invalid selection");
			return null;
		}
		//get the attribute information for created item
		String selectedChoice = choices[selection - 1];
		StoreItem item = null;
		scanner.nextLine();
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

		// Get correct information for each Subclass in ClothingItem
		switch (category) {
			case "clothing" -> {
				System.out.print("Enter gender section of item: ");
				String genderSection = scanner.nextLine();
				System.out.print("Enter material of item: ");
				String material = scanner.nextLine();
				switch (selectedChoice) {
					case "Outerwear" -> {
						System.out.print("Enter size of item: ");
						String size = scanner.nextLine();
						System.out.print("Enter waterproof state of item (true/false): ");
						boolean waterproof = scanner.nextBoolean();
						System.out.print("Enter UV Protection state of item (true/false): ");
						boolean uvProtection = scanner.nextBoolean();
						item = new Outerwear(name, brand, price, description, returnPolicy, genderSection, material, size, waterproof, uvProtection);
					}
					case "Shirt" -> {
						System.out.print("Enter size of item: ");
						String size = scanner.nextLine();
						System.out.print("Enter shirt type of item: ");
						String shirtType = scanner.nextLine();
						System.out.print("Enter color of item: ");
						String color = scanner.nextLine();
						item = new Shirt(name, brand, price, description, returnPolicy, genderSection, material, size, shirtType, color);
					}
					case "Shoe" -> {
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
			// Get correct information for each Subclass in ElectronicItem
			case "electronics" -> {
				System.out.print("Enter screen width of item (in.): ");
				double screenWidth = scanner.nextDouble();
				System.out.print("Enter screen length of item (in.): ");
				double screenLength = scanner.nextDouble();
				switch (selectedChoice) {
					case "Laptop" -> {
						System.out.print("Enter touch screen state of item (true/false): ");
						boolean touchScreen = scanner.nextBoolean();
						System.out.print("Enter running windows state of item (true/false): ");
						boolean runningWindows = scanner.nextBoolean();
						item = new Laptop(name, brand, price, description, returnPolicy, screenWidth, screenLength, touchScreen, runningWindows);
					}
					case "Phone" -> {
						System.out.print("Enter hotspot state of item (true/false): ");
						boolean hotspotActivated = scanner.nextBoolean();
						System.out.print("Enter cameras of item: ");
						int cameras = scanner.nextInt();
						item = new Phone(name, brand, price, description, returnPolicy, screenWidth, screenLength, hotspotActivated, cameras);
					}
					case "TV" -> {
						System.out.print("Enter smart TV state of item (true/false): ");
						boolean smartTV = scanner.nextBoolean();
						System.out.print("Enter cable state of item (true/false): ");
						boolean cable = scanner.nextBoolean();
						return new TV(name, brand, price, description, returnPolicy, screenWidth, screenLength, smartTV, cable);
					}
				}
			}
			// Get correct information for each Subclass in FoodItem
			case "food" -> {
				System.out.print("Enter color of item: ");
				String color = scanner.nextLine();
				System.out.print("Enter taste of item: ");
				String taste = scanner.nextLine();
				switch (selectedChoice) {
					case "Fruit" -> {
						System.out.print("Enter texture of item: ");
						String texture = scanner.nextLine();
						System.out.print("Enter family of item: ");
						String family = scanner.nextLine();
						item = new Fruit(name, brand, price, description, returnPolicy, color, taste, texture, family);
					}
					case "Shelf Stable" -> {
						System.out.print("Enter texture of item: ");
						String texture = scanner.nextLine();
						System.out.print("Enter shelf life of item (years): ");
						int shelfLife = scanner.nextInt();
						item = new ShelfStable(name, brand, price, description, returnPolicy, color, taste, texture, shelfLife);
					}
					case "Vegetable" -> {
						System.out.print("Enter texture of item: ");
						String texture = scanner.nextLine();
						System.out.print("Enter family of item: ");
						String family = scanner.nextLine();
						item = new Vegetable(name, brand, price, description, returnPolicy, color, taste, texture, family);
					}
				}
			}
			// Get correct information for each Subclass in HouseholdItem
			case "household" -> {
				System.out.print("Enter home area of item: ");
				String homeArea = scanner.nextLine();
				switch (selectedChoice) {
					case "Cleaning Supply" -> {
						System.out.print("Enter bottled state of item (true/false): ");
						boolean bottled = scanner.nextBoolean();
						System.out.print("Enter toxic state of item (true/false): ");
						boolean toxic = scanner.nextBoolean();
						item = new CleaningSupply(name, brand, price, description, returnPolicy, homeArea, bottled, toxic);
					}
					case "Furniture" -> {
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
		return item; //get item
	}
	/**
	* sellMenu displays the decision menu for sellItem
	* contains the switch statement that calls the appropriate methods based on the decision
	*/
	private static void sellMenu() {
		boolean selling = true;
		
		
		//Initializing a list of QuantifiedItems, a class made specifically to show the number of items in the user's cart
		List<QuantifiedItem> inventoryBackup = new ArrayList<>();

		//Iterates through the main inventory and adds the quantity attribute into the new inventory
		for (QuantifiedItem item : inventory) {
			inventoryBackup.add(new QuantifiedItem(item.getStoreItem(), item.getQuantity()));
		}

		
		//Now that we have the new inventory of QuantifiedItems, the cart is initialzed to store the quantity of items
		//As well as the item of that quantity
		List<QuantifiedItem> cart = new ArrayList<>();
		sellLoop: while (selling) {
			displaySellMenu();
			
			//Calls the sellItem method with different parameters depending on the case
			switch (scanner.nextInt()) {
				case 1 -> sellItem("clothing", cart);
				case 2 -> sellItem("electronics", cart);
				case 3 -> sellItem("food", cart);
				case 4 -> sellItem("household", cart);
					
				//displays the items currently in the cart
				case 5 -> {
					System.out.println("\n" + getHeader("Cart", 20, false));
					displayItems(cart, true);

				//calls confirmCheckout and exits the loop if the user really wants to checkout
				}
				case 6 -> {
					if (confirmCheckout(cart)) {
						selling = false;
						break sellLoop;
					}
				}

				//Exit without buying anything and exits the loop, also empties the cart
				case 7 -> {
					selling = false;
					inventory = inventoryBackup;
					break sellLoop;
				}
			}
		}
	}

	/*
	*The sellItem method
	*Takes in the category and the list of quantifed items as parameters
	*/
	private static void sellItem(String category, List<QuantifiedItem> cart) {
		boolean selling = true;
		while (selling) {
			System.out.println("\n" + getHeader("Current inventory for " + category.toLowerCase(), 0, false));

			//initializes the list of items of the chosen category
			List<QuantifiedItem> items = filterItems(inventory, category);

			//stores the number of items in the list
			int returnIndex = items.size() + 1;

			
			//Displays the number of items of the chosen category as well as their quantity
			//Does this by referencing two different lists
			System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-100s %-30s%n",
				"Option", "Stock", "Type", "Name", "Brand", "Price ($)", "Description", "Return Policy");
			for (int i = 0; i < items.size(); i++) {
				QuantifiedItem item = items.get(i);
				StoreItem storeItem = item.getStoreItem();
				System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10.2f %-100s %-30s%n",
					(i + 1) + ".", item.getQuantity() + "x", storeItem.getType(), storeItem.getName(),
					storeItem.getBrand(), storeItem.getPrice(), storeItem.getDescription(), storeItem.getReturnPolicy());
			}
			
			//Allows the user to select the item they want to buy
			System.out.println(returnIndex + ". Exit\n");
			System.out.print("Please enter your selection: ");
			int selection = scanner.nextInt();

			//if selction is more than what is in stock, it's an invalid selection 
			if (selection < 1 || selection > returnIndex) {
				System.out.println("Invalid selection");
				continue;
			} 
			else if (selection == returnIndex) {
				selling = false;
				return;
			}

			//lets the user select the amount of a given item they want to buy
			QuantifiedItem item = items.get(selection - 1);
			System.out.print("Please enter quantity: ");
			int quantity = scanner.nextInt();
			if (quantity > item.getQuantity()) {
				System.out.println("There is only " + item.getQuantity() + "x of this item in stock.");
				continue;
			}
			//adds a new quantified item to the cart, designed to show how many of it are in the cart as well as it's name and other attribtes
			QuantifiedItem cartItem = new QuantifiedItem(item.getStoreItem(), quantity);
			item.subQuantity(quantity);
			if (item.getQuantity() <= 0)
				inventory.remove(item);
			addToCart(cart, cartItem);
		}
	}

	/**
	*addToCart adds an item to the cart list
	*Increases the quantity of it after it has been added as well
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
	*displaySellMenu works in tandem with sellMenu
	*This is the menu that displays what is available to buy as well as other options for usability purposes
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
	* confirmCheckout confirm total checkout price
	*
	* @param List cart
	*
	*returns nothing
	*/
	private static boolean confirmCheckout(List<QuantifiedItem> cart) {
		
		System.out.println("\n" + getHeader("Confirm Checkout", 0, false));
		displayItems(cart, true);
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
		if (selection < 1 || selection > 2) {
			System.out.println("Invalid selection");
			return false;
		} else if (selection == 1) {
			checkout(cart);
			return true;
		}
		return false;
	}
	
	/**
	 * checkout
	 * @param List cart
	 *
	 *returns nothing
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
	 * filterItems checks if item is part of a specific subclass of storeItem
	 * @param list items
	 * @param category
	 *
	 * returns List
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
	 * displayItems function
	 * @param List items
	 * @params vertical
	 *
	 * returns nothing
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
	 * getHeader function
	 * @param headerText
	 * @param chars
	 * @param inline
	 * returns string that gives proper header for menu display
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
