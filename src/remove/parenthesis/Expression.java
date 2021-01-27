package remove.parenthesis;

public class Expression implements Comparable<Expression>{
    private static final String PADDING = " ";
    private static final char OPEN_PARENTHESIS = '(';
    private static final char CLOSE_PARENTHESIS = ')';
    private final String expression;

    private Expression(String expression){
        this.expression = expression;
    }

    public Expression remove(ParenthesisPairList list){
        return new Expression(removeParenthesis(list));
    }

    private String removeParenthesis(ParenthesisPairList list) {
        return removePaddings(replaceToPadding(list));
    }

    private String replaceToPadding(ParenthesisPairList list) {
        String removedExpression = expression;
        for(ParenthesisPair pair : list){
            removedExpression = replaceToPadding(removedExpression, pair);
        }
        return removedExpression;
    }

    private String replaceToPadding(String expression, ParenthesisPair pair){
        return new StringBuilder().append(beforeOpenParenthesis(expression, pair))
                .append(PADDING).append(insideParenthesisPair(expression, pair))
                .append(PADDING).append(afterCloseParenthesis(expression, pair))
                .toString();
    }

    private String beforeOpenParenthesis(String expression, ParenthesisPair pair) {
        return expression.substring(0, pair.openIndex);
    }

    private String insideParenthesisPair(String expression, ParenthesisPair pair) {
        return expression.substring(pair.openIndex + 1, pair.closeIndex);

    }

    private String afterCloseParenthesis(String expression, ParenthesisPair pair) {
        return expression.substring(pair.closeIndex + 1);
    }

    private String removePaddings(String expression) {
        return expression.replace(PADDING, "");
    }

    public String value(){
        return expression;
    }

    public boolean isOpenParenthesis(int index){
        return expression.charAt(index) == OPEN_PARENTHESIS;
    }

    public boolean isCloseParenthesis(int index){
        return expression.charAt(index) == CLOSE_PARENTHESIS;
    }

    public int length(){
        return expression.length();
    }

    public String toString(){
        return expression;
    }

    public int compareTo(Expression other){
        return expression.compareTo(other.expression);
    }

    public boolean equals(Object object){
        return expression.equals(((Expression)object).expression);
    }

    public int hashCode(){
        return expression.hashCode();
    }

    public static Expression of(String expression){
        return new Expression(expression);
    }
}
