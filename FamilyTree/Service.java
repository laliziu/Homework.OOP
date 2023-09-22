package FamilyTree;

import java.time.LocalDate;

public class Service {
    private long id;
    private FamilyTree activeTree;

    public Service(){
        activeTree = new FamilyTree();
    }
    public Service(FamilyTree tree){
        activeTree = tree;
    }
    public String addHuman(String name, String genderString, String birthDate,
                           long idFather, long idMother){
        Human father = activeTree.getById(idFather);
        Human mother = activeTree.getById(idMother);
        Gender gender = Gender.valueOf(genderString);
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        Human human = new Human(name, gender, humanBirthDate, father, mother);
        activeTree.add(human);
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
