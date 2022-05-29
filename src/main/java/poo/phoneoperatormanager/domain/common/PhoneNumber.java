package poo.phoneoperatormanager.domain.common;

import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;

public class PhoneNumber {
    private final String value;
    
    public PhoneNumber(String phoneNumber) throws InvalidPhoneNumberException {
        final String PHONE_PATTERN = "^(00213|\\+213|0)(5|6|7)[0-9]{8}$";
        
        if (!phoneNumber.matches(PHONE_PATTERN)) {
            throw new InvalidPhoneNumberException();
        }
        
        value = phoneNumber;
    }
    
    public String value() {
        return value;
    }
    
    
    public boolean equals(String phone) {
        return phone.equals(value);
    }
    
    @Override
    public String toString() {
        return value;
    }
}
