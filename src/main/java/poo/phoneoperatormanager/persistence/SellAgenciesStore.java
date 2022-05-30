package poo.phoneoperatormanager.persistence;


import poo.phoneoperatormanager.domain.operator.SellAgency;
import poo.phoneoperatormanager.exeptions.AgencyNotExistException;
import poo.phoneoperatormanager.exeptions.PhoneNumberAlreadyExistException;

import java.util.HashMap;

public class SellAgenciesStore {
    
    private static final HashMap<String, SellAgency> store = new HashMap<String, SellAgency>();
    
    public static SellAgency save(SellAgency agency) {
        return store.put(agency.getPhoneNumber().value(), agency);
    }
    
    public static SellAgency saveThrowsIfAlreadyExist(SellAgency agency) throws PhoneNumberAlreadyExistException {
        if (isExist(agency))
            throw new PhoneNumberAlreadyExistException();
        
        return store.put(agency.getPhoneNumber().value(), agency);
    }
    
    public static SellAgency getPerPhoneNumber(String phone) {
        return store.get(phone);
    }
    
    public static SellAgency getPerPhoneNumberThrowsIfNotExist(String phone) throws AgencyNotExistException {
        if (!isExist(phone))
            throw new AgencyNotExistException();
        
        return getPerPhoneNumber(phone);
    }
    
    public static SellAgency delete(SellAgency agency) {
        return store.remove(agency.getPhoneNumber().value());
    }
    
    public static SellAgency delete(String phone) {
        return store.remove(phone);
    }
    
    public static SellAgency deleteThrowsIfNotExist(SellAgency agency) throws AgencyNotExistException {
        if (!isExist(agency))
            throw new AgencyNotExistException();
        
        return delete(agency);
    }
    
    public static SellAgency deleteThrowsIfNotExist(String phone) throws AgencyNotExistException {
        if (!isExist(phone))
            throw new AgencyNotExistException();
        
        return delete(phone);
    }
    
    public static boolean isExist(SellAgency agency) {
        return isExist(agency.getPhoneNumber().value());
    }
    
    public static boolean isExist(String phoneNumber) {
        SellAgency agency = store.get(phoneNumber);
        return agency != null;
    }
    
}
