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
        str = str.substring(index + target.length());
        index = str.indexOf(target);
    }

    public boolean hasNext() {
        return index >= 0;
    }

    public String prevTargetString() {
        return str.substring(0, index);
    }

    public String postTargetString() {
        if(index + target.length() > str.length()) {
            return "";
        }

        if(str.substring(index + target.length()).contains(target)) {
            throw new CurrentIsNotLastTargetException(String.format("%s is post target string and has target[%s]", str.substring(index + target.length()), target));
        }

        return str.substring(index + target.length());
    }

    public static HighlightSplitter splitter(String str, String target) {
        return new HighlightSplitter(str, target);
    }
}
