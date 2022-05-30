package poo.phoneoperatormanager.domain.operator;

import poo.phoneoperatormanager.domain.common.Address;
import poo.phoneoperatormanager.domain.common.PhoneNumber;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;

public class SellAgency {
    
    private String name;
    private Address address;
    private PhoneNumber phoneNumber;
    private AgencyType type;
    
    public SellAgency(String name, String wilaya, String commun, String phoneNumber, AgencyType type) throws InvalidPhoneNumberException {
        this.name = name;
        this.address = new Address(wilaya, commun);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.type = type;
    }
    
    public String getName() {
        return name;
    }
    
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public AgencyType getType() {
        return type;
    }
    
    @Override
    public String toString() {
        return "\n Agency name          : " + name +
                "\n Agency Address       : " + address +
                "\n Agency Phone Number  : " + phoneNumber +
                "\n Agency Type          : " + type;
    }
}
