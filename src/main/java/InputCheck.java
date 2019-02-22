public class InputCheck {

    public boolean stringCheck(String toExamine){
        return toExamine.length() != toExamine.replaceAll(
                "[~#@*+%{}<>\\[\\]|\"\\_^]", "").length();
    }
}