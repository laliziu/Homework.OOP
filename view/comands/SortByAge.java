package view.comands;

import view.Console;

public class SortByAge extends Command{
    public SortByAge(Console console) {
        super(console);
        description = "по возрасту";
    }

    @Override
    public void execute(String text) {
        console.sortByAge();
    }
}
