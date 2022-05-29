package poo.phoneoperatormanager.domain.client;

import poo.phoneoperatormanager.domain.common.PhoneNumber;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BlockedClient {
    private PhoneNumber phoneNumber;
    private String reason;
    private Date blockedAt;
    
    public BlockedClient(String phoneNumber, String reason) throws InvalidPhoneNumberException {
        this.reason = reason;
        this.phoneNumber = new PhoneNumber(phoneNumber);
        blockedAt = new Date();
    }
    
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
    
    public String getReason() {
        return reason;
    }
    
    public Date getBlockedAt() {
        return blockedAt;
    }
    
    @Override
    public String toString() {
        return "\n Phone Number    : " + phoneNumber +
                "\n Reason          : " + reason +
                "\n Blocked At      : " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(blockedAt);
        
    }
}
