/*
    USAGE

        consoleColors cc = new consoleColors();
        cc.printTxtGreen("text").printTxtYellow("Ok yay").printTxtUnderline("---- OMG ----").print(true);

        The "print()" method takes 1 boolean argument. True is for new line and false is for no new line.
*/

public class consoleColors {
    /*
        30 black
        31 red
        32 green
        33 yellow
        34 blue
        35 magenta
        36 cyan
        37 white
        40 black background
        41 red background
        42 green background
        43 yellow background
        44 blue background
        45 magenta background
        46 cyan background
        47 white background
        1 make bright (usually just bold)
        21 stop bright (normalizes boldness)
        4 underline
        24 stop underline
        0 clear all formatting
    */

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_UNDERLINE = "\u001B[4m";
    public static final String ANSI_ITALIC = "\u001B[3m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";


    // the text buffer
    public static StringBuilder txtToPrint;

    public consoleColors() {
        txtToPrint = new StringBuilder();
    }

    public void print(boolean newline) {
        if (newline==true) {
            System.out.println(txtToPrint.toString());
        } else {
            System.out.print(txtToPrint.toString());
        }
    }

    public void clearTxtBuffer() {
        this.txtToPrint.setLength(0);
    }

    public consoleColors printTxtRed(String txt) {
        txtToPrint.append(ANSI_RED + txt + ANSI_RESET);
        return this;
    }

    public consoleColors printTxtGreen(String txt) {
        txtToPrint.append(ANSI_GREEN + txt + ANSI_RESET);
        return this;
    }

    public consoleColors printTxtBlue (String txt) {
        txtToPrint.append(ANSI_BLUE + txt + ANSI_RESET);
        return this;
    }


    public consoleColors printTxtYellow(String txt) {
        txtToPrint.append(ANSI_YELLOW + txt + ANSI_RESET);
        return this;
    }

    public consoleColors printTxtUnderline(String txt) {
        txtToPrint.append(ANSI_UNDERLINE + txt + ANSI_RESET);
        return this;
    }

    public consoleColors printTxtItalic(String txt) {
        txtToPrint.append(ANSI_UNDERLINE + txt + ANSI_RESET);
        return this;
    }

}