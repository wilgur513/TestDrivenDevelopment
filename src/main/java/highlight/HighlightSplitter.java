package highlight;

public class HighlightSplitter {
    private final String target;
    private String str;
    private int index;
    private String prevTargetString;
    private boolean isOnlyTargetWord;

    private HighlightSplitter(String str, String target) {
        this.str = str;
        this.target = target;
        this.prevTargetString = null;
    }

    public void next() {
        if(!hasNext()) {
            throw new CurrentIsLastTargetException(String.format("str[\"%s\"] does not have target[\"%s\"]", str, target));
        }

        initDefaultPrevTargetStringAndIsOnlyTargetWord();
        findTarget();
    }

    private void initDefaultPrevTargetStringAndIsOnlyTargetWord() {
        prevTargetString = "";
        isOnlyTargetWord = false;
    }

    private void findTarget() {
        index = str.indexOf(target);

        if(index >= 0) {
            setPrevTargetStringAndIsOnlyTargetWord();
            str = str.substring(index + target.length());
        }
    }

    private void setPrevTargetStringAndIsOnlyTargetWord() {
        setPrevTargetString();
        setIsOnlyTargetWord();
    }

    private void setPrevTargetString() {
        prevTargetString = str.substring(0, index);
    }

    private void setIsOnlyTargetWord() {
        checkPrevCharacter();
        checkPostCharacter();
    }

    private void checkPrevCharacter() {
        isOnlyTargetWord = index == 0 ? true : str.charAt(index - 1) == ' ';
    }

    private void checkPostCharacter() {
        if(index + target.length() < str.length()) {
            isOnlyTargetWord &= str.charAt(index + target.length()) == ' ';
        } else {
            isOnlyTargetWord &= true;
        }
    }

    public boolean hasNext() {
        return str.contains(target);
    }

    public boolean isOnlyTargetWord() {
        if(prevTargetString == null) {
            throw new NotCallNextException("isOnlyTargetWord is not setting, must call next()");
        }

        return isOnlyTargetWord;
    }

    public String prevTargetString() {
        if(prevTargetString == null) {
            throw new NotCallNextException("prevTargetString is not setting, must call next()");
        }

        return prevTargetString;
    }

    public String postTargetString() {
        if(str.contains(target)) {
            throw new CurrentIsNotLastTargetException(String.format("postTargetString[\"%s\"] has next target[\"%s\"]", str, target));
        }

        return str;
    }

    public static HighlightSplitter splitter(String str, String target) {
        return new HighlightSplitter(str, target);
    }
}
