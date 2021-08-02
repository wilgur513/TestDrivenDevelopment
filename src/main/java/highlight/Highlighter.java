package highlight;

public class Highlighter {
    private static final String NOTE = "note";
    private static final String PRE_HIGHLIGHT = "{";
    private static final String POST_HIGHLIGHT = "}";

    public String highlight(String str) {
        if(notHasNote(str)) {
            return str;
        }
        return preNoteString(str) + highlightedNote() + postNoteString(str);
    }

    private boolean notHasNote(String str) {
        return noteIndex(str) < 0;
    }

    private String preNoteString(String str) {
        return str.substring(0, noteIndex(str));
    }

    private String postNoteString(String str) {
        if(noteIndex(str) + NOTE.length() > str.length()) {
            return "";
        }
        return str.substring(noteIndex(str) + NOTE.length());
    }

    private int noteIndex(String str) {
        return str.indexOf(NOTE);
    }

    private String highlightedNote() {
        return PRE_HIGHLIGHT + NOTE + POST_HIGHLIGHT;
    }
}
