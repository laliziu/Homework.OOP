package view.comands;

import view.Console;

public class SortByDateBirth extends Command{
    public SortByDateBirth(Console console) {
        super(console);
        description = "по дате рождения";
    }

    @Override
    public void execute(String text) {
        console.sortByDateBirth();
    }
}
