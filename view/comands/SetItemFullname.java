package view.comands;

import view.Console;

public class SetItemFullname extends Command{
    public SetItemFullname(Console console) {
        super(console);
        description = "ФИО";
    }

    @Override
    public void execute(String itemIndex) {
        console.setFullname(itemIndex);
    }
}

