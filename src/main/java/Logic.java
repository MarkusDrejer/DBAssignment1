import java.util.InputMismatchException;
import java.util.List;

public class Logic {

    private DB db = new DB();

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

    public void deleteChoice(int itemID) throws InputMismatchException{
        validIds(itemID);
        db.deleteProduct(itemID);
    }

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



    private void validIds(int itemID){
        List<Integer> idList = db.allIds();
        for(int i = 0; i < idList.size(); i++){
            if(itemID == idList.get(i)){
                return;
            }
        }
        throw new InputMismatchException("Id does not exist");
    }

    private void nameCheck(String toExamine){
        if(toExamine.length() != toExamine.replaceAll(
                "[~'#@*+%{}<>\\[\\]|\"\\_^]", "").length()){
            throw new InputMismatchException("Illegal Characters");
        }
    }

    private void price_shelfCheck(int toExamine){
        if(toExamine < 0 || toExamine > 1000){
            throw new InputMismatchException("Invalid Location Chosen");
        }
    }

    private void locationCheck(int toExamine){
        if(toExamine < 1 || toExamine > 3){
            throw new InputMismatchException("Invalid Shelf Chosen");
        }
    }
}