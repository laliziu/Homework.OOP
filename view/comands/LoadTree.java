package view.comands;

import view.Console;

public class LoadTree extends Command {
    public LoadTree(Console console) {
        super(console);
        description = "Загрузить из файла";
    }

    @Override
    public void execute(String text) {
        console.loadTree();
    }
}