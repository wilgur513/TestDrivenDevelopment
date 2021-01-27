package remove.parenthesis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ParenthesisPairList implements Iterable<ParenthesisPair>{
    private final List<ParenthesisPair> list;

    private ParenthesisPairList(List<ParenthesisPair> list) {
        this.list = list;
    }

    private ParenthesisPairList(){
        this.list = new ArrayList<>();
    }

    public ParenthesisPairList addAndNew(ParenthesisPair pair){
        List<ParenthesisPair> newList = new ArrayList<>(list);
        newList.add(pair);
        return new ParenthesisPairList(newList);
    }

    public void add(ParenthesisPair pair){
        list.add(pair);
    }

    public ParenthesisPair get(int index){
        return list.get(index);
    }

    public boolean isValidIndex(int index){
        return 0 <= index && index < list.size();
    }

    public Iterator<ParenthesisPair> iterator(){
        return list.iterator();
    }

    public String toString(){
        return list.toString();
    }

    public static ParenthesisPairList empty(){
        return new ParenthesisPairList();
    }
}
