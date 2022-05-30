package poo.phoneoperatormanager.cli.operator_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.domain.operator.CoveringPercentage;
import poo.phoneoperatormanager.persistence.CoveringPercentagesStore;

import java.util.Collection;

public class SeeAllCoveragePercentagesCommand implements Command {
    
    @Override
    public void execute() {
        Collection<CoveringPercentage> percentages = CoveringPercentagesStore.getAll();
        
        if (percentages.size() == 0)
            System.out.println("No percentages found");
        
        else
            for (CoveringPercentage percentage : percentages)
                System.out.println(percentage);
        
        
    }
}
