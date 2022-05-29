package poo.phoneoperatormanager.domain.client;

import poo.phoneoperatormanager.exeptions.InvalidEmailException;

public class Email {
    private final String value;
    
    public Email(String email) throws InvalidEmailException {
        final String EMAIL_PATTERN = "^(.+)@(.+)$";
        
        if (!email.matches(EMAIL_PATTERN)) {
            throw new InvalidEmailException();
        }
        
        value = email;
    }
    
    public String value() {
        return value;
    }
    
    @Override
    public String toString() {
        return value;
    }
}

