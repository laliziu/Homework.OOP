package view.comands;

import view.Console;

public class SetGenderMale extends Command{
    public  SetGenderMale(Console console){
        super(console);
        description = "Мужской п.";
    }
    @Override
    public void execute(String text) {
        console.setGenderMaleForAdd(text);
    }
}
