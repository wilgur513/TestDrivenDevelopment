package highlight;

public class Highlighter {
    public String highlight(String str) {
        if(noteIndex(str) < 0) {
            return str;
        }

        String result = str.substring(0, noteIndex(str)) + "{note}";

        if(noteIndex(str) + "note".length() > str.length()) {
            return result;
        }

        return result + str.substring(noteIndex(str) + "note".length());
    }

    private int noteIndex(String str) {
        return str.indexOf("note");
    }


}
