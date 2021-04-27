package remove.parenthesis;

public class ExpressionMaker {
    private final Expression origin;
    private final ParenthesisPairList pairs;

    private ExpressionMaker(Expression expression, ParenthesisPairFinder finder) {
        this.origin = expression;
        this.pairs = finder.getParenthesisPairs();
    }

    public static ExpressionMaker create(final Expression expression){
        return new ExpressionMaker(expression, new ParenthesisPairFinder(expression));
    }

    public ExpressionList getExpressionList(){
        return makeExpressionList(0, ParenthesisPairList.empty())
                .removeAndNew(origin)
                .distinct()
                .sort();
    }

    private ExpressionList makeExpressionList(int index, ParenthesisPairList wantToRemove){
        return pairs.isValidIndex(index) ? handleParenthesisPair(index, wantToRemove) :
                        createHasOneRemovedExpressionList(wantToRemove);
    }

    private ExpressionList handleParenthesisPair(int index, ParenthesisPairList wantToRemove) {
        return ExpressionList.concat(removeParenthesisPair(index, wantToRemove),
                keepParenthesisPair(index, wantToRemove));
    }

    private ExpressionList removeParenthesisPair(int index, ParenthesisPairList wantToRemove) {
        return makeExpressionList(index + 1, wantToRemove.addAndNew(pairs.get(index)));
    }

    private ExpressionList keepParenthesisPair(int index, ParenthesisPairList wantToRemove) {
        return makeExpressionList(index + 1, wantToRemove);
    }

    private ExpressionList createHasOneRemovedExpressionList(ParenthesisPairList wantToRemove) {
        return ExpressionList.of(removedExpression(wantToRemove));
    }

    private Expression removedExpression(ParenthesisPairList wantToRemove) {
        return origin.remove(wantToRemove);
    }
}
