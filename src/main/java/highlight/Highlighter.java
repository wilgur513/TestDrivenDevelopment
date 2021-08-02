package highlight;

public class Highlighter {
    public String highlight(String str) {
        int index = str.indexOf("note");

        if(index < 0) {
            return str;
        }

        String result = str.substring(0, index) + "{note}";

        if(index + "note".length() > str.length()) {
            return result;
        }

        return result + str.substring(index + "note".length());
    }
}
