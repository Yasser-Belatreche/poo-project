package poo.phoneoperatormanager.cli.main_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.cli.bonuses_management_menu.BonusesManagementMenu;

public class OpenBonusesManagementMenuCommand implements Command {
    
    @Override
    public void execute() {
        new BonusesManagementMenu();
    }
}
