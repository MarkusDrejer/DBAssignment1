import java.util.Scanner;

public class UserInterface {

    Scanner console = new Scanner(System.in);
    consoleColors cc = new consoleColors();
    InputCheck ic = new InputCheck();
    DB db = new DB();

    public UserInterface(){

        String userInput = "";                          //Uncertain if input should be of String type

        while(!userInput.equals("/quit")) {

            System.out.println("Welcome, please choose: ");
            cc.printTxtBlue("1. Select data\n")
                    .printTxtYellow("2. Update data\n")
                    .printTxtRed("3. Delete data\n")
                    .printTxtPurple("4. Insert data")
                    .print(true);

            userInput = console.next();

            if(userInput.length() > 1){                 //Not perfect check condition
                System.out.println("Invalid Input");
            } else {
                switch (userInput.charAt(0)) {
                    case '1':
                       db.selectProducts();
                        break;
                    case '2':
                        update();
                        break;
                    case '3':
                        delete();
                        break;
                    case '4':
                        System.out.println("Product Name:");
                        String productName = console.next();
                        System.out.println("Product Location:");
                        String productLocation = console.next();
                        System.out.println("Product Price:");
                        int productPrice = console.nextInt();
                        db.insertProduct(productName, productLocation, productPrice);
                        break;
                }
            }
            cc.clearTxtBuffer();
        }
    }

    private void select(){

    }

    private void update(){

    }

    private void delete(){

    }

    private void insert(){
        System.out.println("Please enter Product name");

        String productInput = console.next();

        if(ic.stringCheck(productInput)){
            System.out.println("Illegal input please try again");
            insert();
        } else {
            System.out.println("Valid input");
        }
    }
}