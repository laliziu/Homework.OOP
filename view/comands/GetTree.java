package view.comands;

import view.Console;

public class GetTree extends  Command{
    public GetTree(Console console) {
        super(console);
        description = "Вывести дерево подробно";
    }

    @Override
    public void execute(String text) {
        console.printTree();
    }
}

