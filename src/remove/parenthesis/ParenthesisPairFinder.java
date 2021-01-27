package remove.parenthesis;

import java.util.Stack;
import java.util.stream.IntStream;

public class ParenthesisPairFinder {
    private final Expression expression;
    private final ParenthesisPairList list;
    private final Stack<Integer> stack;

    public ParenthesisPairFinder(Expression expression) {
        this.expression = expression;
        list = ParenthesisPairList.empty();
        stack = new Stack<>();
        find();
    }

    public ParenthesisPairList getParenthesisPairs() {
        return list;
    }

    private void find() {
        IntStream.range(0, expression.length()).forEach(this::search);
    }

    private void search(int index){
        if(isCloseParenthesis(index)){
            storeParenthesisPair(index);
        }

        if(isOpenParenthesis(index)){
            storeOpenParenthesisIndex(index);
        }
    }

    private boolean isCloseParenthesis(int index) {
        return expression.isCloseParenthesis(index);
    }

    private boolean isOpenParenthesis(int index) {
        return expression.isOpenParenthesis(index);
    }

    private void storeParenthesisPair(int closeIndex) {
        list.add(ParenthesisPair.of(openIndex(), closeIndex));
    }

    private void storeOpenParenthesisIndex(int index) {
        stack.push(index);
    }

    private int openIndex(){
        return stack.pop();
    }
}
