package poo.phoneoperatormanager.persistence;

import poo.phoneoperatormanager.domain.operations.PhoneCall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class PhoneCallsStore {
    
    private static final HashMap<UUID, PhoneCall> store = new HashMap<UUID, PhoneCall>();
    
    
    public static PhoneCall save(PhoneCall call) {
        return store.put(call.getCallId(), call);
    }
    
    public static ArrayList<PhoneCall> findCallsOf(String phoneNumber) {
        ArrayList<PhoneCall> targetCalls = new ArrayList<PhoneCall>();
        
        store.forEach((id, call) -> {
            if (call.getReceiverNumber().equals(phoneNumber) || call.getCallerNumber().equals(phoneNumber))
                targetCalls.add(call);
        });
        
        return targetCalls;
    }
}
