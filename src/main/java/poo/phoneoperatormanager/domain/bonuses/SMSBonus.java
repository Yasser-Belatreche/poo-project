package poo.phoneoperatormanager.domain.bonuses;

import poo.phoneoperatormanager.exeptions.InvalidPhoneNumberException;

import java.text.ParseException;

public class SMSBonus extends Bonus {
    
    private final int numOfSMSs;
    
    public SMSBonus(String beneficiaryNumber, String expiringDate, int numOfSMSs) throws InvalidPhoneNumberException, ParseException {
        super(beneficiaryNumber, expiringDate);
        this.numOfSMSs = numOfSMSs;
    }
    
    public int getNumOfSMSs() {
        return numOfSMSs;
    }
    
    @Override
    public String toString() {
        return super.toString()
                + "\n Number of SMS      : " + numOfSMSs;
    }
}
