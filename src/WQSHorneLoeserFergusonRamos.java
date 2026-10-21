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
                    sellItem();
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

    public static void sellItem(){
        //display header
        System.out.printf("%n%s%n", "------------------------------" +
                "--------------------------------------------------");
        System.out.printf("%n%-34s%s%n", "", "Selling Item");
        System.out.printf("%n%s%n", "------------------------------" +
                "--------------------------------------------------");
    }

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
        inventory.add(new StoreItem("Dog", "FN90", "Mutt", 4.66, 7));
        inventory.add(new HouseholdItem("test", "test1", "test2", 89.1, 3, "floor"));
        inventory.add(new CleaningSupply("David", "DV13", "Fish", 809.45, 90, "Closet", true, true));
        inventory.add(new Furniture("Couch", "SI12", "IKEA", 1200.99, 3, "Living Room", 10, 5, 6));
    }

    public static void calculateSalesPrice(){
    }

    public static void searchCategory(){
    }
}
