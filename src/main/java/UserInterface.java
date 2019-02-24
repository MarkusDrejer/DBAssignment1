import java.util.Scanner;

public class UserInterface {

    private Scanner console = new Scanner(System.in);
    private consoleColors color = new consoleColors();
    private InputLogic inputs = new InputLogic();
    private SelectLogic sl = new SelectLogic();

    public UserInterface(){

        String userInput = "";                          //Uncertain if input should be of String type

        while(!userInput.equals("/quit")) {

            System.out.println("Welcome to the Database program");
            color.printTxtBlue("1. Select data\n")
                    .printTxtYellow("2. Update data\n")
                    .printTxtRed("3. Delete data\n")
                    .printTxtPurple("4. Insert data\n")
                    .print(false);

            System.out.print("Please choose: ");
            userInput = console.next();
            color.clearTxtBuffer();

                switch (userInput.charAt(0)) {
                    case '1':
                        color.printTxtBlue("\n\n" + sl.selectRetrieve()).print(true);
                        break;
                    case '2':
                        update();
                        break;
                    case '3':
                        delete();
                        break;
                    case '4':
                        insert();
                        break;
                }
            System.out.println();
            color.clearTxtBuffer();
            }
    }

    private void update(){


        //ONLY FOR TESTING
        /*DB db = new DB();
        System.out.println("Name");
        String name = console.next();
        System.out.println("Price");
        int price = console.nextInt();
        console.nextLine();
        System.out.println("Location");
        String loc = console.nextLine();
        System.out.println("Item ID");
        int itemID = console.nextInt();
        db.updateProduct(name, price, loc, itemID);*/
    }

    private void delete(){
        System.out.println("\n\n" + sl.selectRetrieve());
        color.printTxtRed("\nPlease select the item you want to delete by choosing its Id: ").print(false);
        color.clearTxtBuffer();

        int itemIDInput = console.nextInt();

        if(sl.deleteChoice(itemIDInput)){
            color.printTxtRed("Sucoloressfully deleted item").print(true);
        } else {
            color.printTxtRed("Item Id does not exist").print(true);
        }
        color.clearTxtBuffer();
    }

    private void insert(){
        color.printTxtPurple("\nProduct Name: ").print(false);
        String nameInput = console.next();
        color.clearTxtBuffer();
        if(inputs.nameCheck(nameInput)){
            System.out.println("Name contains Illegal characters\n");
            insert();
            return;
        }

        color.printTxtPurple("Product Price (0-1000): ").print(false);
        int priceInput = console.nextInt();
        color.clearTxtBuffer();

        color.printTxtPurple("Product Warehouse (1, 2 or 3): ").print(false);
        int locationInput = console.nextInt();
        color.clearTxtBuffer();

        color.printTxtPurple("Product Shelf (0-1000): ").print(false);
        int shelfInput = console.nextInt();
        color.clearTxtBuffer();

        if(inputs.insertIntoDB(nameInput, priceInput, locationInput, shelfInput)){
            System.out.println("Sucoloressfully inserted item");
        } else {
            System.out.println("Failed to insert item, please choose within the range of the numbers specified");
        }
    }
}