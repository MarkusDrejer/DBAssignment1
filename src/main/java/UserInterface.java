import java.util.InputMismatchException;
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
                        color.printTxtBlue(inputs.selectRetrieve().toString()).print(true);
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
        System.out.println(inputs.selectRetrieve());

        try{
        color.printTxtYellow("Select the Id for the product you wish to update: ").print(false);
            color.clearTxtBuffer();
        int itemID = console.nextInt();

        console.nextLine();                 //For empty \n token from nextInt

        color.printTxtYellow("New Product Name: ").print(false);
            color.clearTxtBuffer();
        String newName = console.nextLine();

        color.printTxtYellow("New Price (0-1000); ").print(false);
            color.clearTxtBuffer();
        int newPrice = console.nextInt();

        color.printTxtYellow("New Location (1-3): ").print(false);
            color.clearTxtBuffer();
        int newLocation = console.nextInt();

        color.printTxtYellow("New Shelf (0-1000): ").print(false);
            color.clearTxtBuffer();         //For empty \n token from nextInt in menu
        int newShelf = console.nextInt();


        inputs.dbWrite(newName, newPrice, newLocation, newShelf, itemID);

        } catch(InputMismatchException e){
            color.printTxtYellow(e.getMessage()).print(true);
                console.nextLine();
            return;
        }

        color.printTxtYellow("Successfully Updated Item").print(true);
            color.clearTxtBuffer();
    }

    private void delete(){
        System.out.println("\n\n" + inputs.selectRetrieve());

        try {
        color.printTxtRed("\nPlease select the item you want to delete by its Id: ").print(false);
            color.clearTxtBuffer();
        int itemIDInput = console.nextInt();


        inputs.deleteChoice(itemIDInput);

        } catch (InputMismatchException e){
            color.printTxtRed(e.getMessage()).print(true);
                console.nextLine();         //For empty \n token from nextInt
            return;
        }

        color.printTxtRed("Successfully Deleted Item").print(true);
            color.clearTxtBuffer();
    }

    private void insert(){
        console.nextLine();                 //For empty \n token from nextInt

        color.printTxtPurple("\nProduct Name: ").print(false);
            color.clearTxtBuffer();
        String nameInput = console.nextLine();

        try {
        color.printTxtPurple("Product Price (0-1000): ").print(false);
            color.clearTxtBuffer();
        int priceInput = console.nextInt();

        color.printTxtPurple("Product Location (1-3): ").print(false);
            color.clearTxtBuffer();
        int locationInput = console.nextInt();

        color.printTxtPurple("Product Shelf (0-1000): ").print(false);
            color.clearTxtBuffer();
        int shelfInput = console.nextInt();


        inputs.dbWrite(nameInput, priceInput, locationInput, shelfInput, -1);

        } catch(InputMismatchException e){
            color.printTxtPurple(e.getMessage()).print(true);
                console.nextLine();             //For empty \n token from nextInt
            return;
        }

        color.printTxtPurple("Successfully Inserted Item").print(true);
            color.clearTxtBuffer();
    }
}