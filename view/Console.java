package view;

import model.human.Gender;
import presenter.Presenter;
import view.menus.*;

import java.util.Scanner;



public class Console implements View{
    private Presenter presenter;
    private Scanner scanner;
    private MainMenu menu;
    private boolean work;
    private static final String inputError = "Ошибка ввода!";

    public Console() {
        presenter = new Presenter(this);
        scanner = new Scanner(System.in);
        menu = new MainMenu(this);
        work = true;
    }

    @Override
    public Presenter getPresenter() {
        return presenter;
    }

    @Override
    public void repeatLine() {
        System.out.println(new String(new char[60]).replace("\0", "="));
    }
    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        while (work){
            menu.show();
            int choice = checkOption("Выберите опцию: ",menu.getSize());
            menu.execute(choice-1,"");
        }
    }

    private String scan(String text) {
        System.out.print(text);
        String data = scanner.nextLine();
        return data;
    }
    private void execute() {
        int option = checkOption("выберите действие -> ", menu.getSize());
        menu.execute(option - 1, "");
    }


    private int checkNum(String numStr) {
        while (!isNum(numStr)) {

            System.out.print(inputError+" - введено не число\nПопробуйте еще раз -> ");
            numStr = scanner.next();
        }
        return Integer.parseInt(numStr);
    }
    private boolean isNum(String num) {
        try {
            Integer.parseInt(num);
            return true;
        }
        catch (NumberFormatException e) {
            return false;
        }
    }

private int checkOption(String textToOutput, int size) {
    System.out.println(textToOutput);
    int resultOption = checkNum(new Scanner(System.in).nextLine());
    while (!isValidOptionSize(resultOption, size)) {
        print(inputError+"\nВыберите действие от 1 до "+size);
        System.out.println(textToOutput);
        resultOption = checkNum(new Scanner(System.in).nextLine());
    }
    return resultOption;
}
    private String getValidDateString() {
        int year = checkNum(scan("год в формате YYYY -> "));
        int month = checkNum(scan("месяц в формате M -> "));
        while (month < 1 || month > 12) {
            month = checkNum(scan("месяц д.б. в диапазоне от 1 до 12 -> "));
        }
        int day = checkNum(scan("день в формате D -> "));
        while (!isValidDay(year, month, day)) {
            day = checkNum(scan(" день -> "));
        }
        return year + "," + month + "," + day;
    }
    private Boolean isValidDay(int year, int month, int day) {
        int maxDay = 31;
        switch (month) {
            case 4, 6, 9, 11 -> maxDay = 30;
            case 2 -> {
                if (isLeapYear(year)) {
                    maxDay = 29;
                } else { maxDay = 28; }
            }
        }
        if (day < 1 || day > maxDay) {
            System.out.print(inputError+" - день д.б. в диапазоне от 1 до "+maxDay);
            return false;
        } else return true;
    }
    private boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
    private Boolean isValidOptionSize(int chosenOption, int optionSize) {
        return chosenOption > 0 && chosenOption <= optionSize;
    }

    public void addToTree() {
        String fullName = scan("Введите:\nФИО -> ");
        String dateStr = getValidDateString();
        GenderMenu curMenu = new GenderMenu(this);
        curMenu.show();
        String gender = Integer.toString(checkNum(scan("Выберите пол -> ")));
        String data = fullName+","+dateStr+"," + gender;
        isDone(presenter.addHumanToTree(data));
    }
    public void addHumanToTree(String data) {
        isDone(presenter.addHumanToTree(data));
    }

    public void setGenderFemaleForAdd(String data) {
        Gender gender = Gender.Female;
        ChooseItemClassMenu curMenu = new ChooseItemClassMenu(this);
        curMenu.show();
        int option = checkOption("Выберите \"класс\" добавления -> ", curMenu.getSize());
        curMenu.execute(option - 1, data+","+gender);
    }

    public void setGenderMaleForAdd(String data) {
        Gender gender = Gender.Male;
        ChooseItemClassMenu curMenu = new ChooseItemClassMenu(this);
        curMenu.show();
        int option = checkOption("Выберите \"класс\" добавления -> ", curMenu.getSize());
        curMenu.execute(option - 1, data+","+gender);
    }

    public void changeItemParameter() {
        if (presenter.isTreeEmpty()) {
            print("Дерево пусто");
        } else {
            presenter.getInfo();
            int itemIndex = checkOption("Выберите экземпляр дерева -> ", presenter.getTreeSize());
            ChangeItemMenu curMenu = new ChangeItemMenu(this);
            curMenu.show();
            int option = checkOption("Какой параметр изменить -> ", curMenu.getSize());
            curMenu.execute(option - 1, Integer.toString(itemIndex - 1));
        }
    }

    public void delFromTree() {
        if (presenter.isTreeEmpty()) {
            print("Дерево пусто");
        } else {
            String fullName = scan("Введите ФИО -> ");
//            System.out.println("Введите ФИО -> ");
//            String fullName = new Scanner(System.in).nextLine();
            if (checkItem(fullName)) {
                isDone(presenter.delFromTree(fullName));
            }
        }
    }

    public void printItem() {
        String fullName = scan("Введите ФИО для поиска -> ");
        if (checkItem(fullName)) {
            presenter.getItem(fullName);
        }
    }

    public void exit() {
        presenter.exit();
    }

    public void printTree() {
        presenter.getInfo();
    }

    public void loadTree() {
        String fileName = "tree.out";
        presenter.loadTree(fileName);
    }

    public void getInfo() {if (presenter.isTreeEmpty()) {
        print("Дерево пусто");
    } else {
        this.printTree();
    }
    }

    public void saveTree() {
        SaveTreeMenu curMenu = new SaveTreeMenu(this);
        curMenu.show();
        int option = checkOption("Выберите способ сохранения -> ", curMenu.getSize());
        curMenu.execute(option - 1, "");
    }
    public void setChildren(String itemIndex) {
        String childName = scan("Введите ФИО ребенка -> ");
        if (checkItem(childName)) {
            isDone(presenter.setChild(itemIndex, childName));
        }
    }

    public void setDateBirth(String itemIndex) {
        print("Введите:");
        String dateStr = getValidDateString();
        int birthY = Integer.parseInt(dateStr.split(",")[0]);
        int birthM = Integer.parseInt(dateStr.split(",")[1]);
        int birthD = Integer.parseInt(dateStr.split(",")[2]);
        isDone(presenter.setDateBirth(itemIndex, birthY, birthM, birthD));
    }

    public void setDateEndlife(String itemIndex) {
        print("Введите:");
        String dateStr = getValidDateString();
        int EndlifeY = Integer.parseInt(dateStr.split(",")[0]);
        int EndlifeM = Integer.parseInt(dateStr.split(",")[1]);
        int EndlifeD = Integer.parseInt(dateStr.split(",")[2]);
        isDone(presenter.setDateEndlife(itemIndex, EndlifeY, EndlifeM, EndlifeD));
    }

    public void setFather(String itemIndex) {
        String fatherName = scan("Введите ФИО папы -> ");
        if (checkItem(fatherName)) {
            isDone(presenter.setFather(itemIndex, fatherName));
        }
    }

    public void setMother(String itemIndex) {
        String motherName = scan("Введите ФИО мамы -> ");
        if (checkItem(motherName)) {
            isDone(presenter.setMother(itemIndex, motherName));
        }

    }

    private void isDone(Boolean presenterMethod) {
        if (presenterMethod) {
            successMsg();
        } else { failureMsg(); }

    }
    private void successMsg() {
        print("Успешно!");
    }

    private void failureMsg() {
        print("Неудача!");
    }

    private boolean checkItem(String fullName) {

        if (!isContainsItem(fullName)) {
            failureMsg();
            print("По введеному ФИО экземпляр в дереве не представлен!");
            return false;
        } else {
            return true;
        }
    }

    private Boolean isContainsItem(String fullName) {
        return presenter.isContainsItem(fullName);
    }


    public void sortByAge() {
        presenter.sortByAge();
    }

    public void sortByDateBirth() {
        presenter.sortByDateBirth();
    }

    public void sortByDateBirthReverse() {
        presenter.sortByDateBirthReverse();
    }

    public void sortByName() {
        presenter.sortByName();
    }

    public void saveTreeObject() {
        if (presenter.isTreeEmpty()) {
            print("Дерево пусто");
        } else { isDone(presenter.saveTree("1")); }
    }

    public void setFullname(String itemIndex) {
        String fullName = scan("Введите ФИО -> ");
        isDone(
                presenter.setFullname(itemIndex, fullName));
    }
}

