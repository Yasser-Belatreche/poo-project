package poo.phoneoperatormanager.cli.main_menu;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.cli.main_menu.commands.*;

public class MainMenu {
    private final ArrayList<Command> commands = new ArrayList<Command>();
    
    public MainMenu() {
        fillCommands();
        
        while (true) {
            boolean shouldBreak = showMainMenuAndExecuteRightCommand();
            
            if (shouldBreak)
                break;
        }
    }
    
    private void fillCommands() {
        commands.add(new FillDefaultDataCommand());
        commands.add(new OpenOperatorManagementMenuCommand());
        commands.add(new OpenClientsManagementMenuCommand());
        commands.add(new OpenInvoicesManagementMenuCommand());
        commands.add(new OpenBonusesManagementMenuCommand());
    }
    
    private boolean showMainMenuAndExecuteRightCommand() {
        try {
            int choice = showMenuAndGetChoice();
            
            if (choice == 6)
                return true;
            
            commands.get(choice - 1).execute();
        } catch (InputMismatchException e) {
            System.out.println("\nPlease Provide a valid choice (between 1 and 6)");
        }
        
        return false;
    }
    
    private int showMenuAndGetChoice() throws InputMismatchException {
        int choice;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("\nHello There Please choose one of the following choices : ");
        
        System.out.println("\t 1 - Fill out some default data automatically");
        System.out.println("\t 2 - Operator Management");
        System.out.println("\t 3 - Clients Management");
        System.out.println("\t 4 - Invoices Management");
        System.out.println("\t 5 - Bonuses Management");
        System.out.println("\t 6 - Quit");
        
        System.out.print("\n Your Choice : ");
        
        choice = sc.nextInt();
        
        if (choice < 1 || choice > 6)
            throw new InputMismatchException();
        
        
        return choice;
    }
    
}
