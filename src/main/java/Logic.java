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

    public void deleteChoice(int itemID){
        if(validIds(itemID)){
            db.deleteProduct(itemID);
        } else {
            throw new IllegalArgumentException("Invalid Id");
        }
    }

    public void dbWrite(String productName, int productPrice, int productLocation, int shelfLocation, int itemID){
        if(price_shelfCheck(productPrice) || locationCheck(productLocation) || price_shelfCheck(shelfLocation) || nameCheck(productName)) {
            throw new IllegalArgumentException("Illegal characters");
        } else {
            String dbLocation = "L:0" + productLocation;
            dbLocation += " S:" +shelfLocation;

            if(itemID == -1){
                db.insertProduct(productName, productPrice, dbLocation);
            } else {
                db.updateProduct(productName, productPrice, dbLocation, itemID);
            }
        }
    }

    public boolean validIds(int itemID){
        List<Integer> idList = db.allIds();
        for(int i = 0; i < idList.size(); i++){
            if(itemID == idList.get(i)){
                return true;
            }
        }
        return false;
    }

    private boolean nameCheck(String toExamine){
        return toExamine.length() != toExamine.replaceAll(
                "[~'.#@*+%{}<>\\[\\]|\"\\_^]", "").length();
    }

    private boolean price_shelfCheck(int toExamine){
        return toExamine < 0 || toExamine > 1000;
    }

    private boolean locationCheck(int toExamine){
        return toExamine < 1 || toExamine > 3;
    }
}