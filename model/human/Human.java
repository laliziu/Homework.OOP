package model.human;

import model.family_tree.FamilyTreeItem;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable, FamilyTreeItem<Human> {
    private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private List<Human> parents;
    private List<Human> children;



    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birhdate) {
        this(name, gender, birhdate, null, null, null);
    }

    public Human(String name, Gender gender, LocalDate birhdate, Human father, Human mother) {
        this(name, gender, birhdate, null, father, mother);
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        LocalDate date1 = this.birthDate;
        LocalDate date2 = LocalDate.now();
        if (this.deathDate != null) {
            date2 = this.deathDate;
        }
            long years = date1.until(date2, ChronoUnit.YEARS);
        return Math.toIntExact(years);
    }

    public Gender getGender() {
        return gender;
    }
    public void setFullname(String fullname) {
        this.name = fullname;
    }
    public boolean addParent(Human parent) {
        if (!parents.contains(parent)) {
            children.add(parent);
            return true;
        }
        return false;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(int birthY, int birthM, int birthD){
        this.birthDate = LocalDate.of(birthY, birthM, birthD);
    }
    public void setEndLifeDate(int endlifeY, int endlifeM, int endlifeD){
        this.deathDate = LocalDate.of(endlifeY,endlifeM,endlifeD);
    }

    public void setChildren(Human children) {
        this.children.add(children);
    }

    public void setParents(Human parents) {
        this.parents.add(parents);
    }




    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Human getMother() {
        for (Human parent : parents) {
            if (parent.getGender() == gender.Female) {
                return parent;
            }
        }
        return null;
    }



    public Human getFather() {
        for (Human parent : parents) {
            if (parent.getGender() == gender.Male) {
                return parent;
            }
        }
        return null;
    }

    public List<Human> getParents() {
        return parents;
    }

    public List<Human> getChildren(){
        return children;
    }
    public void setDeathDate(LocalDate deathDate){
        this.deathDate = deathDate;
    }



    @Override
    public String toString() {
        return getInfo();
    }

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(name);
        sb.append(", ");
        sb.append(getBirthDate());
        sb.append(",");
        sb.append(getDeathDate());
        sb.append(",");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }
    public String getFatherInfo(){
        String res = "отец: ";
        Human father = getFather();
        if(father != null){
            res += father.getName();
        } else {
            res += "неизвестен";
        }
        return res;
    }

    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if(mother != null){
            res += mother.getName();
        } else {
            res += "неизвестна";
        }
        return res;
    }
    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if(children.size() != 0){
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++){
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }else{
            res.append("отсутствует");
        }
        return res.toString();
    }
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Human)){
            return false;
        }
        Human human = (Human) obj;
        return human.getName().equals(getName());

    }

    public long getId() {
        return id;
    }
}
