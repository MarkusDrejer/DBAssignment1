import java.util.Scanner;

public class UserInterface {

    private Scanner console = new Scanner(System.in);
    private consoleColors color = new consoleColors();
    private Logic inputs = new Logic();

    public UserInterface(){

        String userInput = "";

        while(!userInput.equals("/quit")) {

            System.out.println("Welcome to the Database program");
            color.printTxtBlue("1. Select data\n")
                    .printTxtYellow("2. Update data\n")
                    .printTxtRed("3. Delete data\n")
                    .printTxtPurple("4. Insert data\n")
                    .printTxtBlack("Type /quit to exit\n")
                    .print(false);

            System.out.print("Please choose: ");
            userInput = console.next();
            color.clearTxtBuffer();

                switch (userInput) {
                    case "1":
                        color.printTxtBlue("\n\n" + inputs.selectRetrieve()).print(true);
                        break;
                    case "2":
                        update();
                        break;
                    case "3":
                        delete();
                        break;
                    case "4":
                        insert();
                        break;
                    default:
                        System.out.println("\nNot a valid input");
                        break;
                }
            System.out.println();
            color.clearTxtBuffer();
            }
    }

    private void update(){
        System.out.println("\n\n" + inputs.selectRetrieve());

        color.printTxtYellow("ID for the product you which to update: ").print(false);
        int itemID = console.nextInt();
        color.clearTxtBuffer();

        console.nextLine();                 //For empty \n token from nextInt

        color.printTxtYellow("New Product Name: ").print(false);
        String newName = console.nextLine();
        color.clearTxtBuffer();

        color.printTxtYellow("New Price (0-1000); ").print(false);
        int newPrice = console.nextInt();
        color.clearTxtBuffer();

        color.printTxtYellow("New Location (1-3): ").print(false);
        int newLocation = console.nextInt();
        color.clearTxtBuffer();

        color.printTxtYellow("New Shelf (0-1000): ").print(false);
        int newShelf = console.nextInt();
        color.clearTxtBuffer();

        if(inputs.insertIntoDB(newName, newPrice, newLocation, newShelf, itemID)){
            System.out.println("\nSuccessfully updated item\n");
        } else {
            System.out.println("\nUnable to update item, Illegal characters included\n");
        }
    }

    private void delete(){
        System.out.println("\n\n" + inputs.selectRetrieve());
        color.printTxtRed("\nPlease select the item you want to delete by choosing its Id: ").print(false);
        color.clearTxtBuffer();

        int itemIDInput = console.nextInt();

        if(inputs.deleteChoice(itemIDInput)){
            color.printTxtRed("Successfully deleted item").print(true);
        } else {
            color.printTxtRed("Item Id does not exist").print(true);
        }
        color.clearTxtBuffer();
    }

    private void insert(){
        console.nextLine();                 //For empty \n token from nextInt

        color.printTxtPurple("\nProduct Name: ").print(false);
        String nameInput = console.nextLine();
        color.clearTxtBuffer();
        if(inputs.nameCheck(nameInput)){
            System.out.println("Name contains Illegal characters\n");
            insert();
            return;
        }

        color.printTxtPurple("Product Price (0-1000): ").print(false);
        int priceInput = console.nextInt();
        color.clearTxtBuffer();

        color.printTxtPurple("Product Location (1-3): ").print(false);
        int locationInput = console.nextInt();
        color.clearTxtBuffer();

        color.printTxtPurple("Product Shelf (0-1000): ").print(false);
        int shelfInput = console.nextInt();
        color.clearTxtBuffer();

        if(inputs.insertIntoDB(nameInput, priceInput, locationInput, shelfInput)){
            System.out.println("Successfully inserted item");
        } else {
            System.out.println("Failed to insert item, please choose within the range of the numbers specified");
        }
    }
}