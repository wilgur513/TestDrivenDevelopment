package highlight;

public class Highlighter {
    private static final String TARGET = "note";
    private static final String PRE_MARKER = "{";
    private static final String POST_MARKER = "}";

    public String highlight(String str) {
        if(noteIndex(str) < 0) {
            return str;
        }

        String result = str.substring(0, noteIndex(str)) + markedNote();
        
        if(noteIndex(str) + TARGET.length() > str.length()) {
            return result;
        }

        return result + str.substring(noteIndex(str) + TARGET.length());
    }

    private int noteIndex(String str) {
        return str.indexOf(TARGET);
    }

    private String markedNote() {
        return PRE_MARKER + TARGET + POST_MARKER;
    }


}
