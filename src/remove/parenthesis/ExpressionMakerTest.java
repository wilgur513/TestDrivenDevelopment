package remove.parenthesis;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ExpressionMakerTest {
    @Test
    public void onlyOneParenthesisPair() {
        ExpressionMaker maker = ExpressionMaker.create(Expression.of("(0)"));
        assertThat(maker.getExpressionList(), is(actualList("0")));
    }

    @Test
    public void hasTwoParenthesisPairAndConsistedOneGroup() {
        ExpressionMaker maker = ExpressionMaker.create(Expression.of("(0/(0))"));
        assertThat(maker.getExpressionList(), is(actualList("(0/0)", "0/0", "0/(0)")));
    }

    @Test
    public void hasTwoParenthesisPairAndConsistedTwoGroup() {
        ExpressionMaker maker = ExpressionMaker.create(Expression.of("(0)/(0)"));
        assertThat(maker.getExpressionList(), is(actualList("(0)/0", "0/0", "0/(0)")));
    }

    @Test
    public void hasThreeParenthesisPairAndConsistedTwoGroup() {
        ExpressionMaker maker = ExpressionMaker.create(Expression.of("(0/(0))+(2)"));
        assertThat(maker.getExpressionList(), is(actualList("(0/(0))+2", "0/(0)+2", "(0/0)+2",
                                                                        "0/0+2", "(0/0)+(2)", "0/(0)+(2)", "0/0+(2)")));
    }

    private ExpressionList actualList(String ...expressions){
        List<Expression> list = Arrays.stream(expressions).map(Expression::of).collect(Collectors.toList());
        return new ExpressionList(list).sort();
    }
}
