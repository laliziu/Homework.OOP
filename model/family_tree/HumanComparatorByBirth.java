package model.family_tree;

import java.util.Comparator;

public class HumanComparatorByBirth <E extends FamilyTreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o1.getBirthDate().compareTo(o2.getBirthDate());
    }
}
