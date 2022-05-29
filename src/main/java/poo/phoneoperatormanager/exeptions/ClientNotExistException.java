package poo.phoneoperatormanager.exeptions;

public class ClientNotExistException extends RuntimeException {
    
    public ClientNotExistException() {
        super("client not exist");
    }
}
