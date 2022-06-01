package poo.phoneoperatormanager.cli.main_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.cli.invoices_management_menu.InvoicesManagementMenu;

public class OpenInvoicesManagementMenuCommand implements Command {
    @Override
    public void execute() {
        new InvoicesManagementMenu();
    }
}
