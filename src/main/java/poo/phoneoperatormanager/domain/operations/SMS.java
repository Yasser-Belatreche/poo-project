package poo.phoneoperatormanager.domain.operations;

import poo.phoneoperatormanager.domain.common.PhoneNumber;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class SMS {
    
    private UUID smsId;
    private PhoneNumber senderNumber;
    private PhoneNumber receiverNumber;
    private String message;
    private SmsStatus status;
    private Date sendingDate;
    
    public SMS(String senderNumber, String receiverNumber, String message, SmsStatus status) throws InvalidPhoneNumberException {
        this.smsId = UUID.randomUUID();
        this.senderNumber = new PhoneNumber(senderNumber);
        this.receiverNumber = new PhoneNumber(receiverNumber);
        this.message = message;
        this.status = status;
        this.sendingDate = new Date();
    }
    
    public UUID getSmsId() {
        return smsId;
    }
    
    public PhoneNumber getReceiverNumber() {
        return receiverNumber;
    }
    
    public Date getSendingDate() {
        return sendingDate;
    }
    
    public PhoneNumber getSenderNumber() {
        return senderNumber;
    }
    
    public SmsStatus getStatus() {
        return status;
    }
    
    public String getMessage() {
        return message;
    }
    
    @Override
    public String toString() {
        return "\n Sender Number       : " + senderNumber +
                "\n Receiver Number     : " + receiverNumber +
                "\n Message             : " + message +
                "\n SMS Status          : " + status +
                "\n Sending Date        : " + new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(sendingDate);
    }
}
