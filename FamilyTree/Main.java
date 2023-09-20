package FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FileHandler fileHandler = new FileHandler();

        FamilyTree tree = testTree();
        System.out.println(tree.getInfo());


        fileHandler.save(tree, "src/FamilyTree/tree.out");

    }

    static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human vasiliy = new Human("Василий", Gender.Male, LocalDate.of(1963, 12, 10));
        Human maria = new Human("Мария", Gender.Female, LocalDate.of(1965, 9, 15));
        tree.add(vasiliy);
        tree.add(maria);

        Human christina = new Human("Кристина", Gender.Female, LocalDate.of(1988, 7, 5), vasiliy, maria);
        Human semyon = new Human("Семен", Gender.Male, LocalDate.of(1991, 1, 25), vasiliy, maria);
        tree.add(christina);
        tree.add(semyon);
        return tree;

    }
//        FileHandler fileHandler = new FileHandler();
//        FamilyTree tree = (FamilyTree)fileHandler.read("src/FamilyTree/tree.out");
//        System.out.println(tree);
    }
