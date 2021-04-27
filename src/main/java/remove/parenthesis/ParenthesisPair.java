package remove.parenthesis;

public class ParenthesisPair {
    public final int openIndex;
    public final int closeIndex;

    private ParenthesisPair(int openIndex, int closeIndex) {
        this.openIndex = openIndex;
        this.closeIndex = closeIndex;
    }

    public String toString(){
        return "(" + openIndex + ", " + closeIndex + ")";
    }

    public static ParenthesisPair of(int openIndex, int closeIndex){
        return new ParenthesisPair(openIndex, closeIndex);
    }
}
