package view.menus;

import view.Console;
import view.comands.Command;
import view.comands.GetItemByName;
import view.comands.GetTree;

import java.util.ArrayList;
import java.util.List;

public class OutputMenu {
    private List<Command> commandsList;

    public OutputMenu(Console console) {
        commandsList = new ArrayList<>();
        commandsList.add(new GetTree(console));

        commandsList.add(new GetItemByName(console));
    }

        public void show(){
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < this.getSize(); i++) {
                sb.append(i + 1).append(". ");
                sb.append(commandsList.get(i).getDescription());
                sb.append("\n");
            }
            System.out.println(sb.substring(0, sb.length() - 1));
        }

        public void execute( int option, String data){
            Command command = commandsList.get(option);
            command.execute(data);
        }

        public int getSize() {
            return commandsList.size();
        }
    }

