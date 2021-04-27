package remove.parenthesis;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Expression expression = Expression.of(new Scanner(System.in).next());
        ExpressionMaker maker = ExpressionMaker.create(expression);

        for(Expression e : maker.getExpressionList()){
            System.out.println(e.value());
        }
    }
}
