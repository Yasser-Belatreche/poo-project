package poo.phoneoperatormanager.cli.operator_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.domain.operator.CoveringPercentage;
import poo.phoneoperatormanager.exeptions.InvalidPercentageException;
import poo.phoneoperatormanager.persistence.CoveringPercentagesStore;

import java.util.Scanner;

public class EditOrAddCoveragePercentageCommand implements Command {
    
    @Override
    public void execute() {
        try {
            Scanner sc = new Scanner(System.in);
            
            System.out.println("\n Please provide the covering percentage information : ");
            
            System.out.print("wilaya : ");
            String wilaya = sc.nextLine();
            
            System.out.print("Percentage : ");
            double percentage = Double.parseDouble(sc.nextLine());
            
            CoveringPercentage coveringPercentage = new CoveringPercentage(wilaya, percentage);
            
            CoveringPercentagesStore.save(coveringPercentage);
            
            System.out.println("Percentage in wilaya " + wilaya + " edited successfully");
        } catch (InvalidPercentageException e) {
            System.out.println("\n Please provide a valid percentage.");
        } catch (Exception e) {
            System.out.println("\n Something went wrong, please try again");
        }
    }
}
