package poo.phoneoperatormanager.exeptions;

public class PhoneNumberAlreadyExistException extends RuntimeException {
    
    public PhoneNumberAlreadyExistException() {
        super("Phone number already exist");
    }
}
