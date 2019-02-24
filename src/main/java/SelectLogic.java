public class SelectLogic {

    DB db = new DB();

    public StringBuilder selectRetrieve(){
        StringBuilder result = new StringBuilder();

        for(Product tmp : db.selectProducts()){
            char[] modifyResult = tmp.toString().toLowerCase().toCharArray();
            modifyResult[0] = Character.toUpperCase(modifyResult[0]);

            for(int i = 1; i < modifyResult.length; i++){
                if(modifyResult[i-1] == ' ' || modifyResult[i-1] == '\n'){
                    modifyResult[i] = Character.toUpperCase(modifyResult[i]);
                }
            }
            result.append(modifyResult);
        }
        return result;
    }
}
