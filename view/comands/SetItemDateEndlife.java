package view.comands;

import view.Console;

public class SetItemDateEndlife extends Command {
    public SetItemDateEndlife(Console console) {
        super(console);
        description = "Дата смерти в формате YYYY M D";
    }

    @Override
    public void execute(String itemIndex) {
        console.setDateEndlife(itemIndex);
    }
}
