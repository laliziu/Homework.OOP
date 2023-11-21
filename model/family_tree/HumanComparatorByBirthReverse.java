package model.family_tree;

import java.util.Comparator;

public class HumanComparatorByBirthReverse<E extends FamilyTreeItem<E>> implements Comparator<E> {
    @Override
    public int compare(E o1, E o2) {
        return o2.getBirthDate().compareTo(o1.getBirthDate());
    }
}
