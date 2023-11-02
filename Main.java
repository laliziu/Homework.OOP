import model.Service;
import model.family_tree.FamilyTree;
import model.human.Gender;
import model.human.Human;
import model.save.base.FileHandler;
import view.Console;
import view.View;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        FileHandler fileHandler = new FileHandler();


        FamilyTree tree = testTree();
        Service service = new Service(tree);
        System.out.println(tree.getInfo());






        fileHandler.save(tree, "src/model/Family_Tree/tree.out");
        System.out.println(service.getInfo());
        service.sortByName();
        System.out.println(service.getInfo());
        service.sortByBirthDate();
        System.out.println(service.getInfo());

        Console view = new Console();
        view.start();
    }

    static FamilyTree testTree() {
        FamilyTree tree = new FamilyTree();

        Human nikita = new Human("Никита", Gender.Male, LocalDate.of(1962, 12, 10));
        Human maria = new Human("Мария", Gender.Female, LocalDate.of(1961, 9, 15));
        tree.add(nikita);
        tree.add(maria);

        Human alisa = new Human("Алиса", Gender.Female, LocalDate.of(1988, 7, 5), nikita, maria);
        Human semyon = new Human("Семен", Gender.Male, LocalDate.of(1987, 1, 25), nikita, maria);
        tree.add(alisa);
        tree.add(semyon);
        return tree;


    }

    //        FileHandler fileHandler = new FileHandler();
//        FamilyTree tree = (FamilyTree)fileHandler.read("src/FamilyTree/tree.out");
//        System.out.println(tree);

}