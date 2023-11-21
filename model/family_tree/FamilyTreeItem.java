package model.family_tree;

import model.human.Human;

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

    int getAge();

    void setBirthDate(int birthY, int birthM, int birthD);

    void setEndLifeDate(int endlifeY, int endlifeM, int endlifeD);

    void setParents(T parents);

    void setChildren(T child);

    void setFullname(String fullName);
}

