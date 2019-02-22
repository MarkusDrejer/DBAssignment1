import java.util.Scanner;

public class UserInterface {

    Scanner console = new Scanner(System.in);
    InputCheck ic = new InputCheck();

    public UserInterface(){

        System.out.println("Welcome, please choose: ");
        String userInput = console.next();

        if(userInput.equals("/quit")){
            return;
        }

        switch (userInput.charAt(0)){
            case '1':
                case1();
                break;
        }
    }

    private void case1(){
        System.out.println("Please enter Product name");

        String productInput = console.next();

        if(ic.stringCheck(productInput)){
            System.out.println("Illegal input please try again");
            case1();

        } else {
            System.out.println("Valid input");
        }
    }
}