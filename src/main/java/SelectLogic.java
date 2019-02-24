public class SelectLogic {

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
}
