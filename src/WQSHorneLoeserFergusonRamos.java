/**
 * @authors Lucas Horne, Luke Loeser, Etan Ferguson, Antonio Ramos
 * Date: 10/10/26
 * Purpose: Driver File for Store Front
 */

import java.util.Scanner;
import java.util.ArrayList;

public class WQSHorneLoeserFergusonRamos{
    //create arrayList for inventory to hold vehicle objects
    static ArrayList<StoreItem> inventory = new ArrayList<>();
    //scanner at class level for all methods to use
    static Scanner input = new Scanner(System.in);

    /**
     * main method
     * @param args
     */
    public static void main(String[] args){
        populateInventory();

        //printItemInfo(inventory);

        boolean active = true; //create "flag" for loop to know when to terminate

        //loop runs until user exits with the selection 6
        while (active){
            //calls display menu method
            displayMenu();
            //gets user selection
            int userChoice = input.nextInt();

            //switch statements for user choices
            switch (userChoice){
                case 1:
                    addItem();
                    break;
                case 2:
                    //sellItem();
                    break;
                default:
                    System.out.printf("%n%s%n", "Invalid input");
                    break;
            }
        }
    }

    public static void displayMenu(){
        //display header
        System.out.printf("%n%s%n", "------------------------------" +
                "--------------------------------------------------");
        System.out.printf("%n%-29s%s%n", "", "Wilmington Quick Shop");
        System.out.printf("%n%s%n", "------------------------------" +
                "--------------------------------------------------");

        //ask the user if they want to add or sell an item
        System.out.printf("%n%s%n","1. Add an item to inventory");
        System.out.printf("%s%n","2. Sell an item");

        //display for user selection
        System.out.printf("%n%s","Please enter your selection: ");
    }

    public static void addItem(){
        //display header
        System.out.printf("%n%s%n", "------------------------------" +
                "--------------------------------------------------");
        System.out.printf("%n%-27s%s%n", "", "Adding Item To Inventory");
        System.out.printf("%n%s%n", "------------------------------" +
                "--------------------------------------------------");

        //prompt user to respond by type
        System.out.printf("%n%s%n", "Item Type:");

        //options
        System.out.printf("%n%s%n","1. Food");
        System.out.printf("%s%n","2. Electronics");
        System.out.printf("%s%n","3. Clothing");
        System.out.printf("%s%n","4. Household");

        //display for user selection
        System.out.printf("%n%s","Please enter your selection: ");

        //gets user selection
        int userChoice = input.nextInt();

        //temp array
        ArrayList<StoreItem> tempList = new ArrayList<>();

        //switch statements for user choices
        switch (userChoice){
            case 1:
                String Category1 = "FoodItem";
                break;
            case 2:
                String Category2 = "ElectronicsItem";
                break;
            case 3:
                String Category3 = "ClothingItem";
                break;
            case 4:
                //iterates through inventory and adds matches to tempList
                for (int i = 0; i < inventory.size(); i++){
                    if (inventory.get(i) instanceof HouseholdItem){
                        tempList.add(inventory.get(i));
                    }
                }

                for (int a = 0; a < tempList.size(); a++){
                    System.out.println(tempList.get(a));
                }
                break;
            default:
                System.out.printf("%n%s%n", "Invalid input");
                break;
        }

        //display inventory by calling corresponding method
        viewInventory();
    }

//    public static void sellItem() {
//        //store item 1 is the class name that i was using for my testing, if you just change it to StoreItem it should work the same
//        ArrayList<StoreItem1> categoryList = new ArrayList<>();
//        ArrayList<StoreItem1> cart = new ArrayList<>();
//
//        boolean stillShopping = true;
//        boolean foundItems = false;
//
//        while(stillShopping == true) {
//
//
//
//            int chosenCategory = 0;
//            int loopControl = 0;
//
//            while (loopControl == 0) {
//
//                System.out.println("What what department would you like to shop in?");
//                System.out.println("1: Food");
//                System.out.println("2: Household");
//                System.out.println("3: Clothing");
//                System.out.println("4: Electronics");
//
//                chosenCategory = input.nextInt();
//                input.nextLine();
//
//                switch (chosenCategory) {
//
//                    case 1:
//                        for (int index = 0; index < inventory.size(); index += 1) {
//                            if (inventory.get(index) instanceof foodItem) {
//                                categoryList.add(inventory.get(index));
//                                foundItems = true;
//                            }
//                        }
//
//                        System.out.println("-----------Here is the stock of our food department-----------------------");
//                        loopControl = 1;
//                        break;
//
//                    case 2:
//                        for (int index = 0; index < inventory.size(); index += 1) {
//                            if (inventory.get(index) instanceof HouseholdItem) {
//                                categoryList.add(inventory.get(index));
//                                foundItems = true;
//                            }
//                        }
//
//                        System.out.println("-----------Here is the stock of our household department-----------------------");
//                        loopControl = 1;
//                        break;
//
//                    //I have cases 3 and 4 commented out since I dont have the classes but the same logic should apply
//                    case 3:
//                     for (int index = 0; index < inventory.size(); index += 1) {
//                     if (inventory.get(index) instanceof clothingItem) {
//                     categoryList.add(inventory.get(index));
//                     foundItems = true;
//                     }
//                     }
//
//                     System.out.println("-----------Here is the stock of our clothing department-----------------------");
//                     loopControl = 1;
//                     break;
//
//                    case 4:
//                     for (int index = 0; index < inventory.size(); index += 1) {
//                     if (inventory.get(index) instanceof electronicsItem) {
//                     categoryList.add(inventory.get(index));
//                     foundItems = true;
//                     }
//                     }
//
//                     System.out.println("-----------Here is the stock of our electronics department------------------------");
//                     loopControl = 1;
//                     break;
//
//                    default:
//                        System.out.printf("Invalid Entry, please enter a number 1-4");
//                        break;
//                }
//                //first switch statement end brackets
//
//            }
//
//            if (foundItems == true) {
//
//                //displayInventory(categoryList);
//
//                System.out.println("Enter the name of the item you want to add to your cart");
//                String chosenItem = input.nextLine();
//
////                for (int index = 0; index < categoryList.size(); index += 1) {
////                    if (chosenItem.equalsIgnoreCase(categoryList.get(index).getName())) {
////                        cart.add(categoryList.get(index));
////
////                        if(categoryList.get(index).getStock() > 0) {
////                            //subtracts 1 from the store's stock
////                            categoryList.get(index).setStock(categoryList.get(index).getStock() - 1);
////                        }
////
////                        else {
////                            System.out.println("The item is out of stock");
////                        }
////
////                    }
////                }
//
//                System.out.println("------------Here is what is currently in your cart------------------------");
//               // displayInventory(cart);
//                System.out.println("--------------------------------------------------------------------------");
//
//                System.out.println("Would you like to keep shopping or check out?");
//                System.out.println("1: keep shopping");
//                System.out.println("2: check out");
//
//                int userDecs = input.nextInt();
//
//                int loopControl2 = 0;
//
//                while (loopControl2 == 0) {
//                    switch (userDecs) {
//                        case 1:
//                            loopControl2 = 1;
//                            categoryList.clear();
//                            break;
//
//                        case 2:
//                            for (int index = 0; index < cart.size(); index += 1) {
//                                inventory.remove(cart.get(index));
//                            }
//
//                            loopControl2 = 1;
//                            stillShopping = false;
//                            break;
//
//                        default:
//                            System.out.println("Please enter a number between 1 and 2");
//                    }
//                }
//            }
//
//            else{
//                System.out.println("Nothing found in that department, please search another department");
//            }
//
//            /*for (int index = 0; index < cart.size(); index += 1) {
//                inventory.remove(cart.get(index));
//            }*/
//        }
//
//        System.out.println("------------Here is what you bought!------------------------");
//        //displayInventory(cart);
//
//    }
    //method end brackets
    public static void viewInventory(){
        //conditional checks to see if inventory is empty
        if (inventory.size() == 0){
            System.out.printf("%n%s%n", "The inventory is currently empty.");
        }
        //if not empty, calls printVehicleInfo method
        else {
            printItemInfo(inventory);
        }
    }

    public static void printItemInfo(ArrayList<StoreItem> items){
        //display header
        System.out.printf("%n%s%n", "------------------------------" +
                "--------------------------------------------------");
        System.out.printf("%n%-32s%s%n", "", "Item Information");
        System.out.printf("%n%s%n", "------------------------------" +
                "--------------------------------------------------");

        for(int a = 0; a < items.size(); a++) {
            System.out.println(items.get(a));
        }

        System.out.printf("%s%n", "");
    }

    public static void populateInventory(){
      //  inventory.add(new StoreItem("Dog", "FN90", "Mutt", 4.66, 7));
      //  inventory.add(new HouseholdItem("test", "test1", "test2", 89.1, 3, "floor"));
       // inventory.add(new CleaningSupply("David", "DV13", "Fish", 809.45, 90, "Closet", true, true));
        //inventory.add(new Furniture("Couch", "SI12", "IKEA", 1200.99, 3, "Living Room", 10, 5, 6));
    }

    public static double calculateSalesPrice(StoreItem calcItem) {
		double salesPrice = 0;
		if (calcItem instanceof FoodItem) {
			salesPrice = calcItem.getPrice() * 1.045;
		}
		return 0;
	}

}
