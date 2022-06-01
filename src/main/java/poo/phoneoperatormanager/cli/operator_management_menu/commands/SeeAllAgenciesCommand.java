package poo.phoneoperatormanager.cli.operator_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.domain.operator.SellAgency;
import poo.phoneoperatormanager.persistence.SellAgenciesStore;

import java.util.Collection;

public class SeeAllAgenciesCommand implements Command {
    
    @Override
    public void execute() {
        Collection<SellAgency> agencies = SellAgenciesStore.getAll();
        
        for (SellAgency agency : agencies) {
            System.out.println(agency);
        }
        
    }
}
