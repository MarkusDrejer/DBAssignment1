public class InputLogic {

    private DB db = new DB();

    public boolean insertIntoDB(String productName, int productPrice, int productLocation, int shelfLocation){
        if(price_shelfCheck(productPrice) || locationCheck(productLocation) || price_shelfCheck(shelfLocation)) {
            return false;
        } else {
            String dbLocation = "L:0" + productLocation;
            dbLocation += " S:" +shelfLocation;
            db.insertProduct(productName, productPrice, dbLocation);
            return true;
        }
    }

    public boolean insertIntoDB(String productName, int productPrice, int productLocation, int shelfLocation, int itemID){
        if(price_shelfCheck(productPrice) || locationCheck(productLocation) || price_shelfCheck(shelfLocation)) {
            return false;
        } else {
            String dbLocation = "L:0" + productLocation;
            dbLocation += " S:" +shelfLocation;
            db.updateProduct(productName, productPrice, dbLocation, itemID);
            return true;
        }
    }

    public boolean nameCheck(String toExamine){
        return toExamine.length() != toExamine.replaceAll(
                "[~'#@*+%{}<>\\[\\]|\"\\_^]", "").length();
    }

    private boolean price_shelfCheck(int toExamine){
        return toExamine < 0 || toExamine > 1000;
    }

    private boolean locationCheck(int toExamine){
        return toExamine < 1 || toExamine > 3;
    }
}