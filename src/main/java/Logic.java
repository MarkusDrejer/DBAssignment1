import java.util.InputMismatchException;
import java.util.List;

public class Logic {

    private DB db = new DB();

    /**
     * Used to select and modify the presentation of all items in the database,
     * Specifically sets the item name to uppercase and adding identifiers to the other parts of info,
     * and puts it all together in a StringBuilder which can be used in the UI
     */
    public StringBuilder selectRetrieve(){
        StringBuilder result = new StringBuilder();
        String modRes;

        for(Product tmpProduct : db.selectProducts()){
            modRes = "\n" +
                    tmpProduct.getProduct_name().toUpperCase() + "\n" +
                    "Id: " + tmpProduct.getPid() +
                    " Price: " + tmpProduct.getProduct_price() +
                    " Location: " + tmpProduct.getProduct_location() +
                    "\n";

            result.append(modRes);
        }
        return result;
    }

    /**
     * Used to delete items in the database by first validating the given id and throwing an exception to the UI if it is invalid,
     * otherwise deletes the selected item
     */
    public void deleteChoice(int itemID) throws InputMismatchException{
        validIds(itemID);
        db.deleteProduct(itemID);
    }

    /**
     * Used to both update and insert items in the database by using the other check methods,
     * furthermore alters the location slightly to the correct format,
     * if the id is specifically set to -1, it will insert instead of update, which will only be done on code basis
     */
    public void dbWrite(String productName, int productPrice, int productLocation, int shelfLocation, int itemID) throws InputMismatchException{
        nameCheck(productName);
        price_shelfCheck(productPrice);
        locationCheck(productLocation);
        price_shelfCheck(shelfLocation);

        String dbLocation = "L:0" + productLocation;
        dbLocation += " S:" +shelfLocation;

        if(itemID == -1){
            db.insertProduct(productName, productPrice, dbLocation);
        } else {
            validIds(itemID);
            db.updateProduct(productName, productPrice, dbLocation, itemID);
        }
    }

    public void createTable(String tablename, String firstColumn, String secondColumn, String thirdColumn) {
        nameCheck(tablename);
        nameCheck(firstColumn);
        nameCheck(secondColumn);
        nameCheck(thirdColumn);

        db.dbCreateTable(tablename, firstColumn, secondColumn, thirdColumn);
    }


    /**
     * Checks an integer for its validity as an Id in the database, by accessing a method in DB that includes all the ids in
     * an ArrayList and throws an exception if the given integer is not found in the database
     */
    private void validIds(int itemID){
        List<Integer> idList = db.allIds();
        for (Integer integer : idList) {
            if (itemID == integer) {
                return;
            }
        }
        throw new InputMismatchException("Id does not exist");
    }

    /**
     * Checks a String for a select amount of illegal characters and throws an exception if one is found
     */
    private void nameCheck(String toExamine){
        if(toExamine.length() != toExamine.replaceAll(
                "[~'#@*+%{}<>\\[\\]|\"\\_^]", "").length()){
            throw new InputMismatchException("Illegal Characters");
        }
    }

    /**
     * Checks for valid shelf's or price inputs and throws an exception if the input is invalid
     */
    private void price_shelfCheck(int toExamine){
        if(toExamine < 0 || toExamine > 1000){
            throw new InputMismatchException("Invalid Location Chosen");
        }
    }

    /**
     * Checks for valid location inputs and throws an exception if the input is invalid
     */
    private void locationCheck(int toExamine){
        if(toExamine < 1 || toExamine > 3){
            throw new InputMismatchException("Invalid Shelf Chosen");
        }
    }
}