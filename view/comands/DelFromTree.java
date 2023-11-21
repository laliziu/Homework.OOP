package view.comands;

import view.Console;

public class DelFromTree  extends Command{
    public DelFromTree(Console console){
        super(console);
        description = "Удалить из дерева: ";
    }

    @Override
    public void  execute(String text){
        console.delFromTree();
    }
}
