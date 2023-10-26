package model;

import model.family_tree.FamilyTree;
import model.family_tree.FamilyTreeItem;
import model.human.Gender;
import model.human.Human;

import java.time.LocalDate;

public class Service<T extends FamilyTreeItem<T>>{
    private long id;
    private FamilyTree<T> activeTree;

    public Service(){
        activeTree = new FamilyTree();
    }
    public Service(FamilyTree tree){
        activeTree = tree;
    }
    public String addHuman(String name, String genderString, String birthDate,
                           long idFather, long idMother){
        T father = activeTree.getById(idFather);
        T mother  = activeTree.getById(idMother);
        Gender gender = Gender.valueOf(genderString);
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        Human human = new Human(name, gender, humanBirthDate, (Human)father, (Human)mother);
        activeTree.add((T)human);
        return "Человек успешно добавлен в дерево";
    }
    public void sortByName(){
        activeTree.sortByName();
    }
    public void sortByBirthDate(){
        activeTree.sortByBirthDate();
    }

    public String getHumanList() {
        return activeTree.getInfo();
    }

    public String getInfo() {
        return activeTree.getInfo();
    }
}
