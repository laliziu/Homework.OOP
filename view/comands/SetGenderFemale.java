package view.comands;

import view.Console;

public class SetGenderFemale extends Command {
    public  SetGenderFemale(Console console){
        super(console);
        description = "Женский п.";
    }
    @Override
    public void execute(String text) {
        console.setGenderMaleForAdd(text);
    }
}
