package highlight;

public class Highlighter {
    private static final String TARGET = "note";

    public String highlight(String str) {
        if(noteIndex(str) < 0) {
            return str;
        }

        String result = str.substring(0, noteIndex(str)) + "{note}";

        if(noteIndex(str) + TARGET.length() > str.length()) {
            return result;
        }

        return result + str.substring(noteIndex(str) + TARGET.length());
    }

    private int noteIndex(String str) {
        return str.indexOf(TARGET);
    }


}
