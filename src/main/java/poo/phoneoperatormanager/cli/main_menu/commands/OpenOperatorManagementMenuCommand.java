package poo.phoneoperatormanager.cli.main_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.cli.operator_management_menu.OperatorManagementMenu;

public class OpenOperatorManagementMenuCommand implements Command {
    
    @Override
    public void execute() {
        new OperatorManagementMenu();
    }
}
