package highlight;

public class HighlightSplitter {
    private String str;
    private final String target;
    private int index;

    private HighlightSplitter(String str, String target) {
        this.str = str;
        this.target = target;
        this.index = str.indexOf(target);
    }

    public void next() {
        str = str.substring(postTargetIndex());
        index = str.indexOf(target);
    }

    public boolean hasNext() {
        return index >= 0;
    }

    public String prevTargetString() {
        return str.substring(0, index);
    }

    public String postTargetString() {
        if(hasPostTargetString()) {
            return "";
        }

        if(str.substring(postTargetIndex()).contains(target)) {
            throw new CurrentIsNotLastTargetException(String.format("%s is post target string and has target[%s]", str.substring(postTargetIndex()), target));
        }

        return str.substring(postTargetIndex());
    }

    private boolean hasPostTargetString() {
        return postTargetIndex() > str.length();
    }

    private int postTargetIndex() {
        return index + target.length();
    }

    public static HighlightSplitter splitter(String str, String target) {
        return new HighlightSplitter(str, target);
    }
}
