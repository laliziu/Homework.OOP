package view.comands;

import view.Console;

public class ChangeItemParameter extends  Command{
    public ChangeItemParameter(Console console) {
        super(console);
        description = "Изменить данные";
    }

    @Override
    public void execute(String text) {
        console.changeItemParameter();
    }

}
