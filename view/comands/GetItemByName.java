package view.comands;

import view.Console;

public class GetItemByName extends Command{

    public GetItemByName(Console console) {
        super(console);
        description = "Найти по имени";
    }

    @Override
    public void execute(String text) {
        console.printItem();
    }
}
