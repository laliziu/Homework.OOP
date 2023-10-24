package model.family_tree;

import java.awt.*;
import java.io.Serializable;
import java.time.LocalDate;

public interface FamilyTreeItem<T> extends Serializable {

    void setId(long id);
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

    }

