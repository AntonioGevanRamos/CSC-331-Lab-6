import java.util.ArrayList;
import java.util.Scanner;

public class testDriver {
    private static ArrayList<StoreItem1> inventory = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        populateInventory();

        displayInventory(inventory);

        sellItem();

        //addItem I also have commented out for now to make it less confusing
        //addItem();
    }

    /*public static void addItem() {

        System.out.println("What typa item son");
        System.out.println("1: food item");
        System.out.println("2: idk everything else");

        ArrayList<StoreItem1> tempList = new ArrayList<>();

        int itemType = input.nextInt();
        input.nextLine();

        switch(itemType){

            case 1:
                for (int index = 0; index < inventory.size(); index += 1) {
                    if (inventory.get(index) instanceof foodItem) {
                        tempList.add(inventory.get(index));
                    }
                }

                break;

            case 2:
                System.out.println("AHHHHHHHHHHHHH");
                break;

            default:
                System.out.println("default");
        }

        for (int index = 0; index < tempList.size(); index += 1) {
            System.out.println(tempList.get(index).toString());
        }

        /**System.out.print("Add a new one or add an existing one??????");
        System.out.print("1: add old");
        System.out.print("2: add new");
        int oldNew = input.nextInt();
        input.nextLine();

        switch(oldNew) {

            case 1:
                System.out.println("enter the name of the item you want to add");

                String itemName = input.nextLine();

                for (int index = 0; index < inventory.size(); index += 1) {
                    if (itemName == inventory.get(index).getName()) {
                        inventory.add(inventory.get(index));
                    }
                }

                for (int index = 0; index < tempList.size(); index += 1) {
                    System.out.println(tempList.get(index).toString());
                }

            case 2:
                System.out.println("enter the attribites of the item you want to add");

                StoreItem item = new StoreItem();

                String newName = input.nextLine();
                item.setName(newName);
        }

    }*/

    /**Method first version and logic by Luke Loeser*/
    public static void sellItem() {
        //store item 1 is the class name that i was using for my testing, if you just change it to StoreItem it should work the same
        ArrayList<StoreItem1> categoryList = new ArrayList<>();
        ArrayList<StoreItem1> cart = new ArrayList<>();

        boolean stillShopping = true;
        boolean foundItems = false;

        while(stillShopping == true) {



            int chosenCategory = 0;
            int loopControl = 0;

            while (loopControl == 0) {

                System.out.println("What what department would you like to shop in?");
                System.out.println("1: Food");
                System.out.println("2: Household");
                System.out.println("3: Clothing");
                System.out.println("4: Electronics");

                chosenCategory = input.nextInt();
                input.nextLine();

                switch (chosenCategory) {

                    case 1:
                        for (int index = 0; index < inventory.size(); index += 1) {
                            if (inventory.get(index) instanceof foodItem) {
                                categoryList.add(inventory.get(index));
                                foundItems = true;
                            }
                        }

                        System.out.println("-----------Here is the stock of our food department-----------------------");
                        loopControl = 1;
                        break;

                    case 2:
                        for (int index = 0; index < inventory.size(); index += 1) {
                            if (inventory.get(index) instanceof HouseholdItem) {
                                categoryList.add(inventory.get(index));
                                foundItems = true;
                            }
                        }

                        System.out.println("-----------Here is the stock of our household department-----------------------");
                        loopControl = 1;
                        break;

                    //I have cases 3 and 4 commented out since I dont have the classes but the same logic should apply
                    /**case 3:
                     for (int index = 0; index < inventory.size(); index += 1) {
                     if (inventory.get(index) instanceof clothingItem) {
                     categoryList.add(inventory.get(index));
                     foundItems = true;
                     }
                     }

                     System.out.println("-----------Here is the stock of our clothing department-----------------------");
                     loopControl = 1;
                     break;*/

                    /**case 4:
                     for (int index = 0; index < inventory.size(); index += 1) {
                     if (inventory.get(index) instanceof electronicsItem) {
                     categoryList.add(inventory.get(index));
                     foundItems = true;
                     }
                     }

                     System.out.println("-----------Here is the stock of our electronics department------------------------");
                     loopControl = 1;
                     break;*/

                    default:
                        System.out.printf("Invalid Entry, please enter a number 1-4");
                        break;
                }
                //first switch statement end brackets

            }

            if (foundItems == true) {

                displayInventory(categoryList);

                System.out.println("Enter the name of the item you want to add to your cart");
                String chosenItem = input.nextLine();

                for (int index = 0; index < categoryList.size(); index += 1) {
                    if (chosenItem.equalsIgnoreCase(categoryList.get(index).getName())) {
                        cart.add(categoryList.get(index));

                        if(categoryList.get(index).getStock() > 0) {
                            //subtracts 1 from the store's stock
                            categoryList.get(index).setStock(categoryList.get(index).getStock() - 1);
                        }

                        else {
                            System.out.println("The item is out of stock");
                        }

                    }
                }

                System.out.println("------------Here is what is currently in your cart------------------------");
                displayInventory(cart);
                System.out.println("--------------------------------------------------------------------------");

                System.out.println("Would you like to keep shopping or check out?");
                System.out.println("1: keep shopping");
                System.out.println("2: check out");

                int userDecs = input.nextInt();

                int loopControl2 = 0;

                while (loopControl2 == 0) {
                    switch (userDecs) {
                        case 1:
                            loopControl2 = 1;
                            categoryList.clear();
                            break;

                        case 2:
                            for (int index = 0; index < cart.size(); index += 1) {
                                inventory.remove(cart.get(index));
                            }

                            loopControl2 = 1;
                            stillShopping = false;
                            break;

                        default:
                            System.out.println("Please enter a number between 1 and 2");
                    }
                }
            }

            else{
                System.out.println("Nothing found in that department, please search another department");
            }

            /*for (int index = 0; index < cart.size(); index += 1) {
                inventory.remove(cart.get(index));
            }*/
        }

        System.out.println("------------Here is what you bought!------------------------");
        displayInventory(cart);

    }
    //method end brackets

    /**North carolina charges a sales tax of 7 or non food items*/
    /**Method by Luke Loeser*/
    public static double calculateTax(StoreItem1 calcItem) {
        double salesPrice = 0;
        if (calcItem instanceof foodItem) {
            salesPrice = calcItem.getPrice() * 1.045;
        }

        else {
            salesPrice = calcItem.getPrice() * 1.07;
        }

        return salesPrice;
    }

    /**Method by Luke Loeser*/
    public static void populateInventory() {
        inventory.add(new Fruit("bumpy", "citrus", "yellow", "sour",
                    "Lemon", "Blonb farms", 2.49, 196, "A sour and yellow fruit that is good in tea"));
        //the nuclearBomb class was SPECIFICALLY for testing to differentiate between foodItem and other classes under a superclass
        inventory.add(new nuclearBomb("Gregory", "United States Military", 10000000000.00, 4,
                "yeah"));
    }

    /**Method by Luke Loeser*/
    public static void displayInventory(ArrayList<StoreItem1> inventory) {
        for (int index = 0; index < inventory.size(); index += 1) {
            System.out.println(inventory.get(index).toString());
        }
    }


}