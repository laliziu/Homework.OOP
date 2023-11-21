package view.comands;

import view.Console;

public class Exit extends  Command {
    public Exit(Console console) {
        super(console);
        description = "Выход";
    }

    @Override
    public void execute(String text) {
        console.exit();
    }
}
