package view.comands;

import view.Console;

public class SaveTree extends  Command{
    public SaveTree(Console console) {
        super(console);
        description = "Сохранить в файл";
    }

    @Override
    public void execute(String text) {
        console.saveTree();

}
}
