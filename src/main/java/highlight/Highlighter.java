package highlight;

public class Highlighter {
    public String highlight(String str) {
        if(str.equals("note")) {
            return "{note}";
        }

        return str;
    }
}
