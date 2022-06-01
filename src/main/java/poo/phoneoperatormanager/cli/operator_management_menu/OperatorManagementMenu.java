package poo.phoneoperatormanager.cli.operator_management_menu;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.cli.clients_management_menu.commands.*;
import poo.phoneoperatormanager.cli.operator_management_menu.commands.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class OperatorManagementMenu {
    
    private final ArrayList<Command> commands = new ArrayList<Command>();
    
    
    public OperatorManagementMenu() {
        fillCommands();
        
        while (true) {
            boolean shouldBreak = showMenuAndExecuteRightCommand();
            
            if (shouldBreak)
                break;
        }
    }
    
    
    private void fillCommands() {
        commands.add(new AddAgencyCommand());
        commands.add(new EditAgencyCommand());
        commands.add(new DeleteAgencyCommand());
        commands.add(new GetAgencyPerPhoneCommand());
        commands.add(new SeeAllAgenciesCommand());
        commands.add(new SeeAllCoveragePercentagesCommand());
        commands.add(new SeeCoveragePercentageInTargetWilayaCommand());
        commands.add(new EditOrAddCoveragePercentageCommand());
    }
    
    private boolean showMenuAndExecuteRightCommand() {
        try {
            int choice = showMenuAndGetChoice();
            
            if (choice == 9)
                return true;
            
            commands.get(choice - 1).execute();
        } catch (InputMismatchException e) {
            System.out.println("Please Provide a valid choice (between 1 and 9)");
        }
        
        return false;
    }
    
    private int showMenuAndGetChoice() throws InputMismatchException {
        Scanner sc = new Scanner(System.in);
        int choice;
        
        System.out.println("\nWelcome to the operator management interface, Please choose one of the following choices : ");
        
        System.out.println("\t 1  - Add Sell Agency");
        System.out.println("\t 2  - Edit Sell Agency");
        System.out.println("\t 3  - Delete Sell Agency");
        System.out.println("\t 4  - Get Sell Agency per phone number");
        System.out.println("\t 5  - See All Agencies");
        System.out.println("\t 6  - See All coverage percentages");
        System.out.println("\t 7  - See coverage percentage in a given wilaya");
        System.out.println("\t 8  - Edit / Add coverage percentage in a wilaya");
        System.out.println("\t 9  - Quit");
        
        System.out.print("\n Your Choice : ");
        
        choice = sc.nextInt();
        
        if (choice < 1 || choice > 9)
            throw new InputMismatchException();
        
        return choice;
    }
}
