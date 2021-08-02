package highlight;

public class Highlighter {
    private static final String TARGET = "note";
    private static final String PRE_MARKER = "{";
    private static final String POST_MARKER = "}";

    public String highlight(String str) {
        if(hasNote(str)) {
            return str;
        }
        
        return preNoteString(str) + markedNote() + postNoteString(str);
    }

    private boolean hasNote(String str) {
        return noteIndex(str) < 0;
    }

    private String preNoteString(String str) {
        return str.substring(0, noteIndex(str));
    }

    private String postNoteString(String str) {
        if(noteIndex(str) + TARGET.length() > str.length()) {
            return "";
        }
        return str.substring(noteIndex(str) + TARGET.length());
    }

    private int noteIndex(String str) {
        return str.indexOf(TARGET);
    }

    private String markedNote() {
        return PRE_MARKER + TARGET + POST_MARKER;
    }
}
