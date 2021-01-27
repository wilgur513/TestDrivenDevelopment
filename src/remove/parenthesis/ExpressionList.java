package remove.parenthesis;

import java.util.*;

public class ExpressionList implements Iterable<Expression>{
    private final List<Expression> list;

    public ExpressionList(Collection<Expression> list) {
        this.list = new ArrayList<>(list);
    }

    public ExpressionList sort(){
        List<Expression> newList = new ArrayList<>(list);
        Collections.sort(newList);
        return new ExpressionList(newList);
    }

    public ExpressionList distinct(){
        List<Expression> newList = new ArrayList<>(new HashSet<>(list));
        return new ExpressionList(newList);
    }

    public ExpressionList removeAndNew(Expression expression){
        List<Expression> newList = new ArrayList<>(list);
        newList.remove(expression);
        return new ExpressionList(newList);
    }

    public String toString(){
        return list.toString();
    }

    public boolean equals(Object object){
        return list.equals(((ExpressionList)object).list);
    }

    @Override
    public Iterator<Expression> iterator() {
        return list.iterator();
    }

    public static ExpressionList of(Expression expression){
        return new ExpressionList(Arrays.asList(expression));
    }

    public static ExpressionList concat(ExpressionList a, ExpressionList b){
        List<Expression> result = new ArrayList<>();
        result.addAll(a.list);
        result.addAll(b.list);
        return new ExpressionList(result);
    }
}
