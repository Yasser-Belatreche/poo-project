package poo.phoneoperatormanager.persistence;


import poo.phoneoperatormanager.domain.operations.PhoneCall;
import poo.phoneoperatormanager.domain.operations.SMS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class SmsStore {
    private static final HashMap<UUID, SMS> store = new HashMap<UUID, SMS>();
    
    
    public static SMS save(SMS sms) {
        return store.put(sms.getSmsId(), sms);
    }
    
    public static ArrayList<SMS> findSmsListOf(String phoneNumber) {
        ArrayList<SMS> smsList = new ArrayList<SMS>();
        
        store.forEach((id, sms) -> {
            if (sms.getReceiverNumber().equals(phoneNumber) || sms.getSenderNumber().equals(phoneNumber))
                smsList.add(sms);
        });
        
        return smsList;
    }
}
