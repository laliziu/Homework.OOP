package view.comands;

import view.Console;

public class SetItemChildren extends Command{
    public SetItemChildren(Console console) {
    super(console);
    description = "Детей";
}

    @Override
    public void execute(String itemIndex) {
        console.setChildren(itemIndex);
    }
}
