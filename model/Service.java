package model;

import model.family_tree.FamilyTree;
import model.family_tree.FamilyTreeItem;
import model.human.Gender;
import model.human.Human;
import model.save.base.FileHandler;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.GregorianCalendar;

public class Service<T extends FamilyTreeItem<T>> {
    private long id;
    private FamilyTree<T> activeTree;

    public Service() {
        activeTree = new FamilyTree();
    }

    public Service(FamilyTree tree) {
        activeTree = tree;
    }

    public String addHuman(String name, String genderString, String birthDate,
                           long idFather, long idMother) {
        T father = activeTree.getById(idFather);
        T mother = activeTree.getById(idMother);
        Gender gender = Gender.valueOf(genderString);
        LocalDate humanBirthDate = LocalDate.parse(birthDate);
        Human human = new Human(name, gender, humanBirthDate, (Human) father, (Human) mother);
        activeTree.add((T) human);
        return "Человек успешно добавлен в дерево";
    }

    public String sortByName() {
        activeTree.sortByName();
        return activeTree.toString();
    }

    public String sortByBirthDate() {
        activeTree.sortByBirthDate();
        return activeTree.toString();
    }

    public String getHumanList() {
        return activeTree.getInfo();
    }

    public String getInfo() {
        return activeTree.getInfo();
    }
    public int getTreeSize() {
        return activeTree.getSize();
    }
    public Boolean isContainsItem(String fullName) {
        return activeTree.getPersonByName(fullName) != null;
    }

    public Boolean compareDates(int year, int month, int day, String dateFromTree) {
        GregorianCalendar dateCompare = new GregorianCalendar(year, month - 1, day);
        DateFormat df = new SimpleDateFormat("dd MMMM yyyy");
        return df.format(dateCompare.getTime()).equals(dateFromTree);
    }

    public String sortByAge() {
        activeTree.sortByAge();
        return activeTree.toString();
    }

    public String sortByDateBirth() {
        activeTree.sortByBirth();
        return activeTree.toString();
    }

    public String sortByDateBirthReverse() {
        activeTree.sortByBirthReverse();
        return activeTree.toString();
    }

    public Boolean delFromTree(String fullName) {
        return activeTree.delByName(fullName);
    }


    public Boolean setDateEndlife(String itemIndex, int endlifeY, int endlifeM, int endlifeD) {
        int index = Integer.parseInt(itemIndex);
        T item = activeTree.getPersonByIndex(index);
        item.setEndLifeDate(endlifeY, endlifeM, endlifeD);
        return LocalDate.of(endlifeY, endlifeM, endlifeD).equals(item.getDeathDate());
    }

    public Boolean setMother(String itemIndex, String motherName) {
        int index = Integer.parseInt(itemIndex);
        T item = activeTree.getPersonByIndex(index);
        T mother = activeTree.getPersonByName(motherName);
        if (mother == null) {
            return false;
        } else {
            item.setParents(mother);
            return motherName.equals(item.getMother().getName());
        }
    }

    public Boolean setFather(String itemIndex, String fatherName) {
        int index = Integer.parseInt(itemIndex);
        T item = activeTree.getPersonByIndex(index);
        T father = activeTree.getPersonByName(fatherName);
        if (father == null) {
            return false;
        } else {
            item.setParents(father);
            return fatherName.equals(item.getFather().getName());
        }
    }
    public Boolean setChild(String itemIndex, String childName) {
        int index = Integer.parseInt(itemIndex);
        T item = activeTree.getPersonByIndex(index);
        T child = activeTree.getPersonByName(childName);
        if (child == null) {
            return false;
        } else {
            item.setChildren(child);
            return item.getChildren().contains(activeTree.getPersonByName(childName));
        }
    }
    public Boolean saveTree(String option) {
        FileHandler obj = new FileHandler();
        return obj.save(activeTree);
    }
    public Boolean loadTree(String filename) {
        FileHandler obj = new FileHandler();
        FamilyTree<T> loadedTree = (FamilyTree<T>) obj.read();
        FamilyTree<T> oldTree = activeTree;
        activeTree = loadedTree;
        return oldTree != loadedTree;
    }
    public void exit() {
        System.exit(0);
    }
    public Boolean isTreeEmpty() {
        return activeTree.isEmpty();
    }

    public Boolean setDateBirth(String itemIndex, int birthY, int birthM, int birthD) {
        int index = Integer.parseInt(itemIndex);
        T item = activeTree.getPersonByIndex(index);
        item.setBirthDate(birthY, birthM, birthD);
        return LocalDate.of(birthY, birthM, birthD).equals(item.getBirthDate());
    }
    public Boolean addHumanToTree(String data) {
        String fullName = data.split(",")[0];
        int birthY = Integer.parseInt(data.split(",")[1]);
        int birthM = Integer.parseInt(data.split(",")[2]);
        int birthD = Integer.parseInt(data.split(",")[3]);
        Gender gender = data.split(",")[4].equalsIgnoreCase("1") ? Gender.Female : Gender.Male;
        Human humanToAdd = new Human(fullName, gender,LocalDate.of(birthY, birthM, birthD) );
        return activeTree.addHuman((T) humanToAdd);
    }

    public String getItemByName(String fullName) {
        T unit = activeTree.getPersonByName(fullName);
        return unit.toString().substring(0,unit.toString().length()-1);
    }

    public Boolean setFullname(String itemIndex, String fullName) {
        int index = Integer.parseInt(itemIndex);
        T item = activeTree.getPersonByIndex(index);
        item.setFullname(fullName);
        return fullName.equals(activeTree.getPersonByIndex(index).getName());
    }
}
