package poo.phoneoperatormanager.cli.clients_management_menu;

import java.util.Scanner;
import java.util.ArrayList;

import java.util.InputMismatchException;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.cli.clients_management_menu.commands.*;


public class ClientsManagementMenu {
    private final ArrayList<Command> commands = new ArrayList<Command>();
    
    
    public ClientsManagementMenu() {
        fillCommands();
        
        while (true) {
            boolean shouldBreak = showMenuAndExecuteRightCommand();
            
            if (shouldBreak)
                break;
        }
    }
    
    private void fillCommands() {
        commands.add(new AddClientCommand());
        commands.add(new EditClientCommand());
        commands.add(new DeleteClientCommand());
        commands.add(new BlockClientCommand());
        commands.add(new UnBlockClientCommand());
        commands.add(new ListBlockedClientsCommand());
        commands.add(new ListClientsPerSubscriptionCommand());
        commands.add(new ListClientsPerWilayaCommand());
        commands.add(new GetClientPerPhoneNumberCommand());
        commands.add(new GetPhoneCallsCommand());
        commands.add(new GetSMSCommands());
        commands.add(new AddPhoneCallCommand());
        commands.add(new AddSMSCommand());
    }
    
    private boolean showMenuAndExecuteRightCommand() {
        try {
            int choice = showMenuAndGetChoice();
            
            if (choice == 14)
                return true;
            
            commands.get(choice - 1).execute();
        } catch (InputMismatchException e) {
            System.out.println("Please Provide a valid choice (between 1 and 14)");
        }
        
        return false;
    }
    
    private int showMenuAndGetChoice() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        System.out.println("\nWelcome to the clients management interface, Please choose one of the following choices : ");
        
        System.out.println("\t 1  - Add Client");
        System.out.println("\t 2  - Edit Client");
        System.out.println("\t 3  - Delete Client");
        System.out.println("\t 4  - Block Client");
        System.out.println("\t 5  - UnBlock Client");
        System.out.println("\t 6  - List Blocked Clients with the blockage details");
        System.out.println("\t 7  - List Clients per subscription type");
        System.out.println("\t 8  - List Clients per wilaya");
        System.out.println("\t 9  - Get Client per phone number");
        System.out.println("\t 10 - Get Client Phone Calls");
        System.out.println("\t 11 - Get Client SMS");
        System.out.println("\t 12 - Add Phone Call");
        System.out.println("\t 13 - Add SMS");
        System.out.println("\t 14 - Quit");
        
        System.out.print("\n Your Choice : ");
        
        choice = sc.nextInt();
        
        if (choice < 1 || choice > 14)
            throw new InputMismatchException();
        
        return choice;
    }
    
}
