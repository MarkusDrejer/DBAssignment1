public class Logic {

    private DB db = new DB();

    public StringBuilder selectRetrieve(){
        StringBuilder result = new StringBuilder();

        for(Product tmp : db.selectProducts()){
            char[] modifyResult = tmp.toString().toLowerCase().toCharArray();

            for(int i = 0; i < modifyResult.length; i++){
                if(i == 0 || modifyResult[i-1] == ' ' || modifyResult[i-1] == '\n'){
                    modifyResult[i] = Character.toUpperCase(modifyResult[i]);
                }
            }
            result.append(modifyResult);
        }
        return result;
    }

    public boolean deleteChoice(int itemID){
        int[] idList = db.allIds();
        for(int i = 0; i < idList.length; i++){
            if(itemID == idList[i]){
                db.deleteProduct(itemID);
                return true;
            }
        }
        return false;
    }

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