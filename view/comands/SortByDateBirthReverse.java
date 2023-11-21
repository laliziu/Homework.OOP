package view.comands;

import view.Console;

public class SortByDateBirthReverse extends Command{
    public SortByDateBirthReverse(Console console) {
        super(console);
        description = "по дате рождения обратная";
    }

    @Override
    public void execute(String text) {
        console.sortByDateBirthReverse();
    }
}
