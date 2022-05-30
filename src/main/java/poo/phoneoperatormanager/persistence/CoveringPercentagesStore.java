package poo.phoneoperatormanager.persistence;

import poo.phoneoperatormanager.domain.operator.CoveringPercentage;
import poo.phoneoperatormanager.exeptions.PercentageNotExistException;

import java.util.Collection;
import java.util.HashMap;

public class CoveringPercentagesStore {
    
    private static final HashMap<String, CoveringPercentage> store = new HashMap<String, CoveringPercentage>();
    
    public static CoveringPercentage save(CoveringPercentage percentage) {
        return store.put(percentage.getWilaya(), percentage);
    }
    
    public static Collection<CoveringPercentage> getAll() {
        return store.values();
    }
    
    public static CoveringPercentage findPerWilaya(String wilaya) {
        return store.get(wilaya);
    }
    
    public static CoveringPercentage findPerWilayaThrowsIfNotExist(String wilaya) throws PercentageNotExistException {
        if (!isExist(wilaya))
            throw new PercentageNotExistException();
        
        return store.get(wilaya);
    }
    
    public static boolean isExist(String wilaya) {
        CoveringPercentage percentage = store.get(wilaya);
        return percentage != null;
    }
}
