package view.comands;

import view.Console;

public class SortByName extends Command{
    public SortByName(Console console) {
        super(console);
        description = "по имени";
    }

    @Override
    public void execute(String text) {
        console.sortByName();
    }
}
