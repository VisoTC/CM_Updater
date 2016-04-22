package net.tonyliu.cmupdater.Tool;

/**
 * Created by szlyt on 2016/4/22 0022.
 */
import net.tonyliu.cmupdater.Item;
import java.util.Comparator;

public class SortComparator implements Comparator<Item> {
    @Override
    public int compare(Item lhs, Item rhs) {
        Item a =  lhs;
        Item b =  rhs;

        return (b.getVersion() - a.getVersion());
    }
}
