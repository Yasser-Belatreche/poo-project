package poo.phoneoperatormanager.cli.operator_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.domain.operator.CoveringPercentage;

import poo.phoneoperatormanager.exeptions.PercentageNotExistException;
import poo.phoneoperatormanager.persistence.CoveringPercentagesStore;

import java.util.Scanner;

public class SeeCoveragePercentageInTargetWilayaCommand implements Command {
    
    @Override
    public void execute() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Please enter the wilaya name : ");
            
            CoveringPercentage percentage = CoveringPercentagesStore.findPerWilayaThrowsIfNotExist(sc.nextLine());
            System.out.println(percentage);
        } catch (PercentageNotExistException e) {
            System.out.println("\n no percentage registered for this wilaya");
        } catch (Exception e) {
            System.out.println("\n Something went wrong, please try again");
        }
    }
}
