package view.comands;

import view.Console;

public class SetItemDateBirth extends Command {
    public SetItemDateBirth(Console console) {
        super(console);
        description = "Дата рождения в формате YYYY M D";
    }

    @Override
    public void execute(String itemIndex) {
        console.setDateBirth(itemIndex);
    }

}
