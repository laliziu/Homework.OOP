package model.family_tree;

import model.family_tree.FamilyTreeItem;

import java.util.Comparator;

public class HumanComparatorByName<E extends FamilyTreeItem> implements Comparator<E> {

    @Override
    public int compare(E o1, E o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
