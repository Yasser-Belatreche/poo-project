package poo.phoneoperatormanager.cli.main_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.cli.clients_management_menu.ClientsManagementMenu;

public class OpenClientsManagementMenuCommand implements Command {
    @Override
    public void execute() {
        new ClientsManagementMenu();
    }
}
