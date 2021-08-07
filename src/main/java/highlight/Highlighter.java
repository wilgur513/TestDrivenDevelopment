package highlight;

import static highlight.HighlightSplitter.splitter;

public class Highlighter {
    private static final String NOTE = "note";
    private static final String PRE_HIGHLIGHT = "{";
    private static final String POST_HIGHLIGHT = "}";

    public String highlight(String str) {
        return highlightString(splitter(str, NOTE));
    }

    private String highlightString(HighlightSplitter splitter) {
        StringBuilder builder = new StringBuilder();

        while(splitter.hasNext()) {
            splitter.next();
            builder.append(splitter.prevTargetString());
            builder.append(noteWord(splitter));
        }

        return builder.append(splitter.postTargetString()).toString();
    }

    private String noteWord(HighlightSplitter splitter) {
        return splitter.isOnlyTargetWord() ?
                PRE_HIGHLIGHT + NOTE + POST_HIGHLIGHT : NOTE;
    }

}
