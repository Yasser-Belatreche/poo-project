package poo.phoneoperatormanager.exeptions;

public class InvalidEmailException extends Exception {
    
    public InvalidEmailException() {
        super("invalid email");
    }
}
