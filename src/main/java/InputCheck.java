public class InputCheck {

    DB db = new DB();

    public boolean stringCheck(String toExamine){
        return toExamine.length() != toExamine.replaceAll(
                "[~#@*+%{}<>\\[\\]|\"\\_^]", "").length();
    }

    /*public String selectLogic(){
        String result = "";
        for(Product tmp : db.selectProducts()){
            result += tmp.toString();
        }

        result = result.toLowerCase();
        char[] modifyResult = result.toCharArray();
        modifyResult[0] = Character.toUpperCase(modifyResult[0]);

        for(int i = 1; i < modifyResult.length; i++){
            if(modifyResult[i-1] == ' ' || modifyResult[i-1] == '\n'){
                modifyResult[i] = Character.toUpperCase(modifyResult[i]);
            }
        }

        return new String(modifyResult);
    }*/

    public StringBuilder selectLogic2(){
        StringBuilder result = new StringBuilder();

        for(Product tmp : db.selectProducts()){
            String tmpResult = tmp.toString();
            tmpResult = tmpResult.toLowerCase();
            char[] modifyResult = tmpResult.toCharArray();
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