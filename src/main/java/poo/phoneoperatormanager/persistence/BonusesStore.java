package poo.phoneoperatormanager.persistence;

import poo.phoneoperatormanager.domain.bonuses.AdditionalSoldBonus;
import poo.phoneoperatormanager.domain.bonuses.Bonus;


import java.util.Collection;
import java.util.HashMap;

public class BonusesStore {
    
    private static final HashMap<String, Bonus> store = new HashMap<String, Bonus>();
    
    public static Bonus save(Bonus bonus) {
        return store.put(bonus.getBeneficiaryNumber().value(), bonus);
    }
    
    public static Collection<Bonus> getAll() {
        return store.values();
    }
}
