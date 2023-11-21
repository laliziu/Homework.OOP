package view.comands;

import view.Console;

public class SetItemMother extends Command{
    public SetItemMother(Console console) {
        super(console);
        description = "Маму";
    }

    @Override
    public void execute(String itemIndex) {
        console.setMother(itemIndex);
    }
}
