package poo.phoneoperatormanager.domain.operations;

import poo.phoneoperatormanager.domain.common.PhoneNumber;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class PhoneCall {
    
    private UUID callId;
    private PhoneNumber callerNumber;
    private PhoneNumber receiverNumber;
    private Duration duration;
    private Date callDate;
    
    
    public PhoneCall(String callerNumber, String receiverNumber, Duration duration) throws InvalidPhoneNumberException {
        this.callId = UUID.randomUUID();
        this.callerNumber = new PhoneNumber(callerNumber);
        this.receiverNumber = new PhoneNumber(receiverNumber);
        this.duration = duration;
        this.callDate = new Date();
    }
    
    public UUID getCallId() {
        return callId;
    }
    
    public Date getCallDate() {
        return callDate;
    }
    
    public PhoneNumber getCallerNumber() {
        return callerNumber;
    }
    
    public Duration getDuration() {
        return duration;
    }
    
    public PhoneNumber getReceiverNumber() {
        return receiverNumber;
    }
    
    
    @Override
    public String toString() {
        return "\n Caller Number        : " + callerNumber +
                "\n Receiver Number      : " + receiverNumber +
                "\n Duration             : " + duration +
                "\n Call Date            : " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(callDate);
    }
}
