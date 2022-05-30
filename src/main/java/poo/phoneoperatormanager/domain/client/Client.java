package poo.phoneoperatormanager.domain.client;


import java.text.ParseException;

import poo.phoneoperatormanager.domain.common.Address;
import poo.phoneoperatormanager.domain.common.PhoneNumber;
import poo.phoneoperatormanager.exeptions.InvalidEmailException;
import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;
import poo.phoneoperatormanager.domain.subscription.Subscription;


public class Client {
    
    private String firstName;
    private String lastName;
    private Email email;
    private Address address;
    private boolean isBlocked;
    private Subscription subscription;
    private PhoneNumber phoneNumber;
    private String contractNumber;
    private Date contractDate;
    
    public Client(String firstName, String lastName, String email, String wilaya, String commun, String phoneNumber, Subscription subscription, String contractNumber, String contractDate, boolean isBlocked) throws ParseException, InvalidPhoneNumberException, InvalidEmailException {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = new Email(email);
        this.address = new Address(wilaya, commun);
        this.phoneNumber = new PhoneNumber(phoneNumber);
        this.subscription = subscription;
        this.contractNumber = contractNumber;
        this.contractDate = new Date(contractDate);
        this.isBlocked = isBlocked;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public Email getEmail() {
        return email;
    }
    
    public PhoneNumber getPhoneNumber() {
        return phoneNumber;
    }
    
    public Date getContractDate() {
        return contractDate;
    }
    
    public String getContractNumber() {
        return contractNumber;
    }
    
    public Subscription getSubscription() {
        return subscription;
    }
    
    public boolean isBlocked() {
        return isBlocked;
    }
    
    public void block() {
        this.isBlocked = true;
    }
    
    public void unblock() {
        this.isBlocked = false;
    }
    
    @Override
    public String toString() {
        return "\n First name         : " + firstName +
                "\n Last name          : " + lastName +
                "\n Email              : " + email +
                "\n Address            : " + address +
                "\n Subscription type  : " + subscription +
                "\n Phone number       : " + phoneNumber +
                "\n Contract number    : " + contractNumber +
                "\n Contract date      : " + contractDate +
                "\n is Blocked         : " + isBlocked;
    }
}
