package poo.phoneoperatormanager.cli.bonuses_management_menu.commands;

import poo.phoneoperatormanager.cli.Command;
import poo.phoneoperatormanager.domain.bonuses.Bonus;
import poo.phoneoperatormanager.persistence.BonusesStore;

import java.util.Collection;

public class SeeAllClientsBenefitsFromBonusCommand implements Command {
    
    @Override
    public void execute() {
        Collection<Bonus> bonuses = BonusesStore.getAll();
        
        for (Bonus bonus : bonuses) {
            System.out.println(bonus);
        }
    }
}
