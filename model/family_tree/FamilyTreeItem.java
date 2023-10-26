package model.family_tree;

import java.util.List;
import java.io.Serializable;
import java.time.LocalDate;

public interface FamilyTreeItem<T> extends Serializable {


    long getId();
    T getFather();
    T getMother();
    boolean addChild(T human);
    boolean addParent(T human);
    String getName();
    LocalDate getDeathDate();
    LocalDate getBirthDate();
    List<T> getParents();
    List<T> getChildren();
    public String getInfo();

    }

