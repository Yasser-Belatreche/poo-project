package poo.phoneoperatormanager.exeptions;

public class InvalidPhoneNumberException extends Exception {
    
    public InvalidPhoneNumberException() {
        super("invlid phone number");
    }
}
