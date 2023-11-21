package view.comands;

import view.Console;

public class SetItemFather extends Command {
    public SetItemFather(Console console) {
        super(console);
        description = "Папу";
    }

    @Override
    public void execute(String itemIndex) {
        console.setFather(itemIndex);
    }
}

