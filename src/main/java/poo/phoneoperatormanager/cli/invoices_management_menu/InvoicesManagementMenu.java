package poo.phoneoperatormanager.cli.invoices_management_menu;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.cli.invoices_management_menu.commands.EstablishInvoiceForGivenNumberCommand;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class InvoicesManagementMenu {
    
    private final ArrayList<Command> commands = new ArrayList<Command>();
    
    
    public InvoicesManagementMenu() {
        fillCommands();
        
        while (true) {
            boolean shouldBreak = showMenuAndExecuteRightCommand();
            
            if (shouldBreak)
                break;
        }
    }
    
    private void fillCommands() {
        commands.add(new EstablishInvoiceForGivenNumberCommand());
    }
    
    private boolean showMenuAndExecuteRightCommand() {
        try {
            int choice = showMenuAndGetChoice();
            
            if (choice == 2)
                return true;
            
            commands.get(choice - 1).execute();
        } catch (InputMismatchException e) {
            System.out.println("Please Provide a valid choice (between 1 and 3)");
        }
        
        return false;
    }
    
    private int showMenuAndGetChoice() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        System.out.println("\nWelcome to the Invoices management interface, Please choose one of the following choices : ");
        
        System.out.println("\t 1 - Establish invoice for a given number");
        System.out.println("\t 2 - Quit");
        
        System.out.print("\n Your Choice : ");
        
        choice = sc.nextInt();
        
        if (choice < 1 || choice > 2)
            throw new InputMismatchException();
        
        return choice;
    }
}
