package view.comands;

import view.Console;

public class SetHuman extends Command {
    public SetHuman(Console console) {
        super(console);
        description = "Человек";
    }

    @Override
    public void execute(String data) {
        console.addHumanToTree(data);
    }
}
