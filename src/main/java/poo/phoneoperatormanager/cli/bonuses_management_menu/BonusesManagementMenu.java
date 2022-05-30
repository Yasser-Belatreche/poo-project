package poo.phoneoperatormanager.cli.bonuses_management_menu;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.cli.bonuses_management_menu.commands.AssignBonusToClientCommand;
import poo.phoneoperatormanager.cli.bonuses_management_menu.commands.SeeAllClientsBenefitsFromBonusCommand;
import poo.phoneoperatormanager.cli.operator_management_menu.commands.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BonusesManagementMenu {
    private final ArrayList<Command> commands = new ArrayList<Command>();
    
    
    public BonusesManagementMenu() {
        fillCommands();
        
        while (true) {
            boolean shouldBreak = showMenuAndExecuteRightCommand();
            
            if (shouldBreak)
                break;
        }
    }
    
    private void fillCommands() {
        commands.add(new AssignBonusToClientCommand());
        commands.add(new SeeAllClientsBenefitsFromBonusCommand());
    }
    
    private boolean showMenuAndExecuteRightCommand() {
        try {
            int choice = showMenuAndGetChoice();
            
            if (choice == 3)
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
        
        System.out.println("\nWelcome to the Bonuses management interface, Please choose one of the following choices : ");
        
        System.out.println("\t 1  - Assign bonus to a client");
        System.out.println("\t 2  - See All clients who benefits from bonuses");
        System.out.println("\t 3  - Quit");
        
        System.out.print("\n Your Choice : ");
        
        choice = sc.nextInt();
        
        if (choice < 1 || choice > 3)
            throw new InputMismatchException();
        
        return choice;
    }
}
