public class InputLogic {

    DB db = new DB();

    public boolean insertIntoDB(String productName, int productPrice, int productLocation, int shelfLocation){
        if(nameCheck(productName) || numberCheck(productPrice) ||
                locationCheck(productLocation) || numberCheck(shelfLocation)) {
            return false;
        } else {
            String dbLocation = "L:0" + productLocation;
            dbLocation += " S:" +shelfLocation;
            db.insertProduct(productName, productPrice, dbLocation);
            return true;
        }
    }

    private boolean nameCheck(String toExamine){
        return toExamine.length() != toExamine.replaceAll(
                "[~#@*+%{}<>\\[\\]|\"\\_^]", "").length();
    }

    private boolean numberCheck(int toExamine){
        return toExamine < 0 || toExamine > 1000;
    }

    private boolean locationCheck(int toExamine){
        return toExamine < 1 || toExamine > 3;
    }
}