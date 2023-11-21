package view.comands;

import view.Console;

public class AddToTree extends Command {
    public AddToTree(Console console) {
        super(console);
        description = "Добавить в дерево";
    }

    @Override
    public void execute(String text) {
        console.addToTree();
    }
}