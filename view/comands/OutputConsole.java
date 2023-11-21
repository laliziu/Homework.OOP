package view.comands;

import view.Console;

public class OutputConsole extends Command{
    public OutputConsole(Console console) {
        super(console);
        description = "Вывести в консоль";
    }

    @Override
    public void execute(String text) {
        console.getInfo();
    }
}
