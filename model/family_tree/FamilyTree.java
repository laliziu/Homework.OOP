package model.family_tree;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<E extends FamilyTreeItem<E>> implements Serializable, Iterable<E> {
    private long humansId;
    private List<E> humanList;

    public FamilyTree(List<E> humanList) {

        this.humanList = humanList;
    }

    public FamilyTree() {

        this(new ArrayList<>());
    }

    public boolean add(E human) {
        if (human == null) {
            return false;
        }
        if (!humanList.contains(human)) {
            humanList.add(human);

            addToParents(human);

            addToChildren(human);
            return true;
        }
        return false;
    }

    private void addToChildren(E human) {
        for (E child : human.getChildren()) {
            child.addParent(human);
        }
    }

    private void addToParents(E human) {
        for (E parent : human.getParents()) {
            parent.addChild(human);
        }
    }

    public E getByName(String name) {
        for (E human : humanList) {
            if (human.getName().equals(name)) {
                return human;
            }
        }
        return null;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("В дереве");
        sb.append(humanList.size());
        sb.append(" объектов: \n");
        for (E human : humanList) {
            sb.append(human.getInfo());
            sb.append("\n");
        }
        return sb.toString();


    }

    @Override
    public Iterator iterator() {
        return new HumanIterator(humanList);
    }

    public void sortByName() {
        humanList.sort(new HumanComparatorByName());
    }

    public void sortByBirthDate() {
        humanList.sort(new HumanComparatorByName());
    }

    public E getById(long id) {
        for (E human : humanList) {
            if (human.getId() == id) {
                return human;
            }

        }
        return null;

    }
}

