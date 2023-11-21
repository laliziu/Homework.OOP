package view.comands;

import view.Console;

public class SaveTreeByObjectStream extends Command {
    public SaveTreeByObjectStream(Console console) {
        super(console);
        description = "C помощью класса ObjectOutputStream";
    }

    @Override
    public void execute(String text) {
        console.saveTreeObject();
    }
}
